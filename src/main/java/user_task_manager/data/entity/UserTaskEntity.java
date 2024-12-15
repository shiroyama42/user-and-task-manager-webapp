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

    @Column(name = "start_date")
    private Date startDate;

    public UserTaskEntity() {
    }

    public UserTaskEntity(int userId, int taskId, Date startDate) {
        this.userId = userId;
        this.taskId = taskId;
        this.startDate = startDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
