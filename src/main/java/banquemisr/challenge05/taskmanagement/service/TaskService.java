package banquemisr.challenge05.taskmanagement.service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banquemisr.challenge05.taskmanagement.model.Task;
import banquemisr.challenge05.taskmanagement.model.TaskStatus;
import banquemisr.challenge05.taskmanagement.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
    public List<Task> getTasksByTitle(String title) {
        return taskRepository.findByTitleContaining(title);
    }
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task) {
        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setStatus(task.getStatus());
        newTask.setPriority(task.getPriority());
        newTask.setDueDate(task.getDueDate());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> searchTasks(String title, String description, TaskStatus status, LocalDate dueDate) {
        return taskRepository.findTasksByCriteria(title, description, status, dueDate);
    }
}
