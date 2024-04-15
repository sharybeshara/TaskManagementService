package banquemisr.challenge05.taskmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import banquemisr.challenge05.taskmanagement.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {
      @Autowired
      UserDetailsServiceImpl userDetailsService;
      
      @Bean
      public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
      }

      @Bean
      public BCryptPasswordEncoder bCryptPasswordEncoder() {
          return new BCryptPasswordEncoder();
      }

      @Bean
      public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
          AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
          AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
          httpSecurity.csrf().disable()
                  .authorizeHttpRequests()
                  .anyRequest()
                  .authenticated()
                  .and()
                  .authenticationManager(authenticationManager)
                  .httpBasic();

          return httpSecurity.build();
      }
}