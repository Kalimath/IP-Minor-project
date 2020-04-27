package be.taskmanager.service;

import be.taskmanager.domain.SubTask;
import be.taskmanager.dto.SubTaskDTO;
import be.taskmanager.repository.SubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.taskmanager.domain.Task;
import be.taskmanager.dto.TaskDTO;
import be.taskmanager.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;
	private final SubTaskRepository subTaskRepository;

	@Autowired
	public TaskServiceImpl(TaskRepository repository, SubTaskRepository subTaskRepository) {
		this.taskRepository = repository;
		this.subTaskRepository = subTaskRepository;
	}


	@Override
	public List<TaskDTO> getTasks() {

		return taskRepository.findAll().stream().map(t ->
		{
			TaskDTO dto = new TaskDTO();
			dto.setDesc(t.getDesc());
			dto.setTitle(t.getTitle());
			dto.setSubTasks(t.getSubTasks());
			dto.setDeadline(t.getDeadline());
			return dto;

		}).collect(Collectors.toList());
	}

	@Override
	public TaskDTO getTask(int id) {
		return getTasks().get(id);
	}

	@Override
	public void addSubTask(int parentId, SubTaskDTO subTask){
		SubTask subTask1 = new SubTask();
		subTask1.setDesc(subTask.getDesc());
		subTask1.setTitle(subTask.getTitle());
		subTaskRepository.save(subTask1);
	}

	@Override
	public void addTask(TaskDTO task) {
		Task task1 = new Task();
		task1.setDesc(task.getDesc());
		task1.setTitle(task.getTitle());
		task1.setDeadline(task.getDeadline());
		taskRepository.save(task1);
	}




}
