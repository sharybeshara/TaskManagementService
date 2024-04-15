package banquemisr.challenge05.taskmanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import banquemisr.challenge05.taskmanagement.model.Task;
import banquemisr.challenge05.taskmanagement.model.TaskStatus;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitleContaining(String title);
    List<Task> findByStatus(String status);  
    List<Task> findByDescriptionContaining(String description);
    List<Task> findByDueDate(LocalDate dueDate);

    @Query("SELECT t FROM Task t WHERE " +
    "(:title IS NULL OR t.title LIKE %:title%) AND " +
    "(:description IS NULL OR t.description LIKE %:description%) AND " +
    "(:status IS NULL OR t.status = :status) AND " +
    "(:dueDate IS NULL OR t.dueDate = :dueDate)")
    List<Task> findTasksByCriteria(@Param("title") String title,
                            @Param("description") String description,
                            @Param("status") TaskStatus status,
                            @Param("dueDate") LocalDate dueDate);

}