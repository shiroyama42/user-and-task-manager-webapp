package user_task_manager.controller;

import org.apache.catalina.User;
import user_task_manager.data.entity.UserEntity;
import user_task_manager.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable("id") int id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public UserEntity saveUser(@RequestBody UserEntity user){
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
}
