package user_task_manager.service.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TaskDTO {
    private int id;
    private String task;
    private LocalDate startDate;
    private Date endDate;
    private boolean completed;
    private Date completionTime;
    private List<UserDTO> users;

    public TaskDTO() {
    }

    public TaskDTO(int id, String task, LocalDate startDate, Date endDate, boolean completed, Date completionTime, List<UserDTO> users) {
        this.id = id;
        this.task = task;
        this.startDate = startDate;
        this.endDate = endDate;
        this.completed = completed;
        this.completionTime = completionTime;
        this.users = users;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}