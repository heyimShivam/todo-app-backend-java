package com.todo.app.Service;

import com.todo.app.DTO.TaskDTO;
import com.todo.app.Entity.TaskEntity;
import com.todo.app.Entity.UserEntity;
import com.todo.app.Repository.TaskRepository;
import com.todo.app.Repository.UserRepository;
import com.todo.app.Utility.TaskNotFoundException;
import com.todo.app.Utility.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class TaskServiceImpl implements TaskService {


    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    public TaskServiceImpl(
            TaskRepository taskRepository,
            UserRepository userRepository
    ) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }


    @Override
    public TaskDTO addTask(UUID userId, TaskDTO taskDTO) {


        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(userId)
                );


        TaskEntity task = new TaskEntity(
                taskDTO.getDescription(),
                taskDTO.getPriority(),
                user
        );


        TaskEntity savedTask = taskRepository.save(task);


        return convertToDTO(savedTask);
    }



    @Override
    public TaskDTO getTask(UUID id) {


        TaskEntity task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException(id)
                );


        return convertToDTO(task);
    }



    @Override
    public TaskDTO updateTask(UUID id, TaskDTO taskDTO) {


        TaskEntity task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException(id)
                );


        if(taskDTO.getDescription() != null){
            task.setDescription(taskDTO.getDescription());
        }


        if(taskDTO.getPriority() != null){
            task.setPriority(taskDTO.getPriority());
        }


        task.setCompleted(taskDTO.isCompleted());


        TaskEntity updatedTask = taskRepository.save(task);


        return convertToDTO(updatedTask);
    }



    @Override
    public String deleteTask(UUID id) {


        TaskEntity task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException(id)
                );


        taskRepository.delete(task);


        return "Task deleted successfully";
    }



    private TaskDTO convertToDTO(TaskEntity task){


        TaskDTO dto = new TaskDTO();

        dto.setId(task.getId());
        dto.setDescription(task.getDescription());
        dto.setPriority(task.getPriority());
        dto.setCompleted(task.isCompleted());


        return dto;
    }
}