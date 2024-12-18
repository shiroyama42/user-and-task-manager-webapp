package user_task_manager.controller;

import org.apache.catalina.User;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import user_task_manager.data.entity.TaskEntity;
import user_task_manager.data.entity.UserEntity;
import user_task_manager.data.repository.TaskRepository;
import user_task_manager.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user_task_manager.service.UserService;

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

    @PreAuthorize("hasAuthority('Admin') or @userService.hasId(#id)")
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable("id") @Param("id") int id, @Autowired UserService userService){
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/tasks")
    @PreAuthorize("hasAuthority('Admin') or @userService.hasId(#id)")
    public List<TaskEntity> getUserTasks(@PathVariable("id") @Param("id") int id, @Autowired UserService userService){
        UserEntity user = userRepository.findById(id).orElse(null);
        return user.getTasks();
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("")
    public UserEntity saveUser(@RequestBody UserEntity user){
        return userRepository.save(user);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/{id}/tasks/{taskId}")
    public UserEntity assignTaskToUser(@PathVariable("id") int userId, @PathVariable("taskId") int taskId){
        UserEntity user =  userRepository.findById(userId).orElse(null);
        TaskEntity task = taskRepository.findById(taskId).orElse(null);

        task.setStartDate(LocalDate.now());


        user.getTasks().add(task);
        return userRepository.save(user);
    }

    @PreAuthorize("hasAuthority('Admin') or @userService.hasId(#id)")
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable("id") @Param("id") int id, @RequestBody UserEntity user, @Autowired UserService userService){
        if(user.getId() > 0){
            return userRepository.save(user);
        }else{
            return null;
        }
    }

    @PreAuthorize("hasAuthority('Admin')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userRepository.deleteById(id);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @DeleteMapping("/{id}/tasks/{taskId}")
    public UserEntity deleteTaskFromUser(@PathVariable("id") int userId, @PathVariable("taskId") int taskId){
        UserEntity user =  userRepository.findById(userId).orElse(null);
        TaskEntity task = taskRepository.findById(taskId).orElse(null);

        user.getTasks().remove(task);
        return userRepository.save(user);
    }
}
