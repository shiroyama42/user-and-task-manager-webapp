package user_task_manager.controller;

import org.apache.catalina.User;
import user_task_manager.data.entity.TaskEntity;
import user_task_manager.data.entity.UserEntity;
import user_task_manager.data.repository.TaskRepository;
import user_task_manager.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/company/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("")
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable("id") int id){
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskEntity> getUserTasks(@PathVariable("id") int userId){
        UserEntity user = userRepository.findById(userId).orElse(null);
        return user.getTasks();
    }

    @PostMapping("")
    public UserEntity saveUser(@RequestBody UserEntity user){
        return userRepository.save(user);
    }


    @PostMapping("/{id}/tasks/{taskId}")
    public UserEntity assignTaskToUser(@PathVariable("id") int userId, @PathVariable("taskId") int taskId){
        UserEntity user =  userRepository.findById(userId).orElse(null);
        TaskEntity task = taskRepository.findById(taskId).orElse(null);

        task.setStartDate(LocalDate.now());


        user.getTasks().add(task);
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable("id") int id, @RequestBody UserEntity user){
        if(user.getId() > 0){
            return userRepository.save(user);
        }else{
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userRepository.deleteById(id);
    }

    @DeleteMapping("/{id}/tasks/{taskId}")
    public UserEntity deleteTaskFromUser(@PathVariable("id") int userId, @PathVariable("taskId") int taskId){
        UserEntity user =  userRepository.findById(userId).orElse(null);
        TaskEntity task = taskRepository.findById(taskId).orElse(null);

        user.getTasks().remove(task);
        return userRepository.save(user);
    }
}
