package user_task_manager.service;

import jakarta.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import user_task_manager.data.entity.DepartmentEntity;
import user_task_manager.data.entity.RoleEntity;
import user_task_manager.data.entity.UserEntity;
import user_task_manager.data.repository.UserRepository;
import user_task_manager.service.dto.LoginDTO;
import user_task_manager.service.dto.RegistrationDTO;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtService jwtService;

    public String registration(RegistrationDTO dto){

        UserEntity userEntity = new UserEntity();

        userEntity.setName(dto.getName());
        userEntity.setEmail(dto.getEmail());
        userEntity.setBirthDate(dto.getBirthDate());
        userEntity.setPhone(dto.getPhone());
        userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        userEntity.setRole(new RoleEntity(2, "User"));
        userEntity.setDepartment(new DepartmentEntity(1, "Default"));

        userEntity = userRepository.save(userEntity);

        return jwtService.generateToken(userEntity, userEntity.getId(), userEntity.getRole());
    }

    public String login(LoginDTO loginDTO){
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );
        var user = userRepository.findByEmail(loginDTO.getEmail());
        return jwtService.generateToken(user, user.getId(), user.getRole());
    }

}
