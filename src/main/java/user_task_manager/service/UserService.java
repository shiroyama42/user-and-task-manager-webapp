package user_task_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import user_task_manager.data.entity.UserEntity;
import user_task_manager.data.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserDetailsService userDetailsService() {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) {
                UserEntity user = repository.findByEmail(email);
                user.authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
                return user;
            }
        };
    }

    public boolean hasId(int id){
        String username =  ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        UserEntity user = repository.findByEmail(username);
        return user.getId() == id;
    }
}