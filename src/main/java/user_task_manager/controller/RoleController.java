package user_task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user_task_manager.data.entity.RoleEntity;
import user_task_manager.data.repository.RoleRepository;

import java.util.List;

@RestController
@RequestMapping("/company/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("")
    public List<RoleEntity> getRoles(){
        return roleRepository.findAll();
    }
}
