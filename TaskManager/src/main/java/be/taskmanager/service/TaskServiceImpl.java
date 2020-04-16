package be.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.taskmanager.domain.Task;
import be.taskmanager.dto.TaskDTO;
import be.taskmanager.repository.TaskRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;

	@Autowired
	public TaskServiceImpl(TaskRepository repository) {
		this.taskRepository = repository;
	}


	@Override
	public List<TaskDTO> getTasks() {

		return taskRepository.findAll().stream().map(t ->
		{
			TaskDTO dto = new TaskDTO();
			dto.setDescription(t.getDesc());
			dto.setName(t.getTitle());
			dto.setTasks(t.getTasks());
			dto.setTime(t.getDeadline());
			return dto;

		}).collect(Collectors.toList());
	}

	@Override
	public TaskDTO getTask(int id) {
		return getTasks().get(id);
	}

	@Override
	@Transactional
	public void addTask(TaskDTO task) {
		Task task1 = new Task();
		task1.setDesc(task.getDescription());
		task1.setTitle(task.getName());
		task1.setDeadline(task.getTime());
		taskRepository.save(task1);
	}


}
