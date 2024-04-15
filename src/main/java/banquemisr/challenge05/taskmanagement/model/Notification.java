package banquemisr.challenge05.taskmanagement.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    private String message;

    @Column(name = "sent_at")
    private LocalDateTime sentAT;
 

    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public String getMessage() {
        return message;
    }
    public LocalDateTime getNotificationDate() {
        return sentAT;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setSentAT(LocalDateTime sentAT) {
        this.sentAT = sentAT;
    }
   
    
}
