package banquemisr.challenge05.taskmanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import banquemisr.challenge05.taskmanagement.model.Task;
import banquemisr.challenge05.taskmanagement.model.TaskStatus;
import banquemisr.challenge05.taskmanagement.model.User;


public interface UserDetailsRepository extends JpaRepository<User, Long> {
    UserDetails findUserByUsername(String username);
   

   

}