package user_task_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_task_manager.data.entity.TaskEntity;
import user_task_manager.data.repository.TaskRepository;
import user_task_manager.service.dto.TaskDTO;
import user_task_manager.service.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> getAllTasks() {
        List<TaskEntity> taskEntities = taskRepository.findAll();
        return taskEntities.stream().map(this::convertToTaskDTO).collect(Collectors.toList());
    }

    private TaskDTO convertToTaskDTO(TaskEntity taskEntity) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(taskEntity.getId());
        taskDTO.setTask(taskEntity.getTask());
        taskDTO.setStartDate(taskEntity.getStartDate());
        taskDTO.setEndDate(taskEntity.getEndDate());
        taskDTO.setCompleted(taskEntity.isCompletion());
        taskDTO.setCompletionTime(taskEntity.getCompletionDate());

        List<UserDTO> userDTOs = taskEntity.getUsers().stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(user.getId());
                    userDTO.setName(user.getName());
                    userDTO.setEmail(user.getEmail());
                    return userDTO;
                }).collect(Collectors.toList());

        taskDTO.setUsers(userDTOs);
        return taskDTO;
    }
}
