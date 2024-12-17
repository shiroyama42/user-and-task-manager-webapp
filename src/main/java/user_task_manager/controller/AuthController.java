package user_task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user_task_manager.service.AuthService;
import user_task_manager.service.dto.LoginDTO;
import user_task_manager.service.dto.RegistrationDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/registration")
    public String registration(@RequestBody RegistrationDTO dto){
        return service.registration(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto){
        return service.login(dto);
    }


}
