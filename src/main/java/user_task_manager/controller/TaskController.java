package user_task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import user_task_manager.data.entity.TaskEntity;
import user_task_manager.data.entity.UserEntity;
import user_task_manager.data.repository.TaskRepository;
import user_task_manager.service.TaskService;
import user_task_manager.service.UserService;
import user_task_manager.service.dto.TaskDTO;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/company/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<TaskDTO>> getTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PreAuthorize("hasAuthority('Admin') or @userService.hasId(#id)")
    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable("id") @Param("id") int id, @Autowired UserService userService){
        return taskRepository.findById(id).orElse(null);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("")
    public TaskEntity saveTask(@RequestBody TaskEntity task){
        task.setStartDate(LocalDate.now());
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    @PutMapping("/{id}")
    public TaskEntity updateTask(@PathVariable("id") int id, @RequestBody TaskEntity task){
        if(task.getId() > 0){
            return taskRepository.save(task);
        }else{
            return null;
        }
    }

    @PreAuthorize("hasAuthority('Admin')")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") int id){
        taskRepository.deleteById(id);
    }
}
