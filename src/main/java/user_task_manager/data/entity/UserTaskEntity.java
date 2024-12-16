package user_task_manager.data.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_task")
@IdClass(UserTaskId.class)
public class UserTaskEntity {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Id
    @Column(name = "task_id")
    private int taskId;

    public UserTaskEntity() {
    }

    public UserTaskEntity(int userId, int taskId) {
        this.userId = userId;
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
