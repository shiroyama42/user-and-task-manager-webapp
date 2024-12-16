package user_task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user_task_manager.data.entity.TaskEntity;
import user_task_manager.data.entity.UserEntity;
import user_task_manager.data.repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/company/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("")
    public List<TaskEntity> getTasks(){
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable("id") int id){
        return taskRepository.findById(id).orElse(null);
    }

    

    @PostMapping("")
    public TaskEntity saveTask(@RequestBody TaskEntity task){
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
