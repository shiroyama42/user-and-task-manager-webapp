package user_task_manager.data.repository;

import user_task_manager.data.entity.UserTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTaskRepository extends JpaRepository<UserTaskEntity, Integer> {

}
