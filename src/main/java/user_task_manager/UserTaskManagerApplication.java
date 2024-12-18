package user_task_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = "user_task_manager")
public class UserTaskManagerApplication {
    public static void main(String[] args){
        SpringApplication.run(UserTaskManagerApplication.class, args);
    }
}
