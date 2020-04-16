package be.taskmanager.service;

import be.taskmanager.domain.Task;
import be.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
	private final TaskRepository repository;

	@Autowired
	public TaskServiceImpl(TaskRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Task> getTasks() {
		return repository.getTasks();
	}

	@Override
	public Task getTask(int id){
		return repository.getTask(id);
	}

	@Override
	public void addTask(Task task){
		repository.addTask(task);
	}

	@Override
	public void editTask(Task task){
		repository.update(task);
	}

	@Override
	public void addSubTask(int mainTaskId, Task task){
		repository.addSubTask(mainTaskId, task);
	}

	@Override
	public List<Task> getSubTasks(int id){
		return repository.getSublist(id);
	}

	/*@Override
	public void addRestaurant(RestaurantDTO restaurantDTO) {
		Task task = new Task(restaurantDTO.getName(), restaurantDTO.getAddress());
		repository.addRestaurant(task);
	}*/
}
