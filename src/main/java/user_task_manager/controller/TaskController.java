package user_task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user_task_manager.data.entity.TaskEntity;
import user_task_manager.data.entity.UserEntity;
import user_task_manager.data.repository.TaskRepository;
import user_task_manager.service.TaskService;
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

    @GetMapping("")
    public ResponseEntity<List<TaskDTO>> getTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable("id") int id){
        return taskRepository.findById(id).orElse(null);
    }

    

    @PostMapping("")
    public TaskEntity saveTask(@RequestBody TaskEntity task){
        task.setStartDate(LocalDate.now());
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public TaskEntity updateTask(@PathVariable("id") int id, @RequestBody TaskEntity task){
        if(task.getId() > 0){
            return taskRepository.save(task);
        }else{
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") int id){
        taskRepository.deleteById(id);
    }
}
