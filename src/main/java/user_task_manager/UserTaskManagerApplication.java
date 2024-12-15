package user_task_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class UserTaskManagerApplication {
    public static void main(String[] args){
        SpringApplication.run(UserTaskManagerApplication.class, args);
    }
}
