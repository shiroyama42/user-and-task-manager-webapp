package user_task_manager.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "task")
    private String task;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "completed")
    private boolean completed = false ;

    @Column(name = "completion_date")
    private Date completionDate;

    @ManyToMany(mappedBy = "tasks")
    @JsonIgnore
    private List<UserEntity> users = new ArrayList<>();

    public TaskEntity() {
    }

    public TaskEntity(Date endDate, String task, int id, LocalDate startDate, boolean completed, Date completionDate) {
        this.endDate = endDate;
        this.task = task;
        this.id = id;
        this.startDate = LocalDate.now();
        this.completed = false;
        this.completionDate = completionDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean isCompletion() {
        return completed;
    }

    public void setCompletion(boolean completed) {
        this.completed = completed;
        if(completed){
            this.completionDate = new Date();
        }else{
            this.completionDate = null;
        }
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
