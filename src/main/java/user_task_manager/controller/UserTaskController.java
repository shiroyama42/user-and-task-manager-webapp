package user_task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import user_task_manager.data.entity.UserEntity;
import user_task_manager.data.entity.UserTaskEntity;
import user_task_manager.data.repository.UserRepository;
import user_task_manager.data.repository.UserTaskRepository;

import java.util.List;

@RestController
@RequestMapping("/company/usertasks")
public class UserTaskController {

    @Autowired
    private UserTaskRepository userTaskRepository;

    @GetMapping("")
    public List<UserTaskEntity> getUserTasks(){
        return userTaskRepository.findAll();
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("")
    public UserTaskEntity addTaskToUser(@RequestBody UserTaskEntity userTask) {
        return userTaskRepository.save(userTask);
    }

}
