package banquemisr.challenge05.taskmanagement.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "changed_field", nullable = false)
    private String changedField;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by")
    private User changedBy;

    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt = LocalDateTime.now();
    
    public Long getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public String getChangeField() {
        return changedField;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setChangeField(String changeField) {
        this.changedField = changeField;
    }

    public String getChangedField() {
        return changedField;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public User getChangedBy() {
        return changedBy;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedField(String changedField) {
        this.changedField = changedField;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public void setChangedBy(User changedBy) {
        this.changedBy = changedBy;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
    
}

