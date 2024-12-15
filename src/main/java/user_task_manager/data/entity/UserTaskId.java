package user_task_manager.data.entity;

public class UserTaskId{

    private int userId;
    private int taskId;

    public UserTaskId() {
    }

    public UserTaskId(int userId, int taskId) {
        this.userId = userId;
        this.taskId = taskId;
    }
}
