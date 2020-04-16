package be.taskmanager.service;


import be.taskmanager.domain.Task;
import be.taskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {

	List<TaskDTO> getTasks();

	void addTask (TaskDTO task);

	TaskDTO getTask(int id);
}
