package banquemisr.challenge05.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import banquemisr.challenge05.taskmanagement.model.Task;
import banquemisr.challenge05.taskmanagement.model.TaskStatus;
import banquemisr.challenge05.taskmanagement.service.TaskService;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.findAllTasks());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.findTaskById(id).isPresent()) {
            taskService.deleteTask(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.findTaskById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setStatus(updatedTask.getStatus());
                    task.setPriority(updatedTask.getPriority());
                    task.setDueDate(updatedTask.getDueDate());
                    taskService.saveTask(task);
                    return ResponseEntity.ok(task);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchTasks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate) {

                TaskStatus taskStatus = null;
                if (status != null) {
                    try {
                        taskStatus = TaskStatus.valueOf(status.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        return ResponseEntity.badRequest().body("Invalid status value: " + status);
                    }
                }
        
        List<Task> tasks = taskService.searchTasks(title, description, taskStatus, dueDate);
        return ResponseEntity.ok(tasks);
    }
}
