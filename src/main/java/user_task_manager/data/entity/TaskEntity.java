package user_task_manager.data.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "task")
    private String task;

    @Column(name = "end_date")
    private Date endDate;

    public TaskEntity() {
    }

    public TaskEntity(Date endDate, String task, int id) {
        this.endDate = endDate;
        this.task = task;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}