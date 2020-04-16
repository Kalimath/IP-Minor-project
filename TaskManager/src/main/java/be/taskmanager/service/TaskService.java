package be.taskmanager.service;

import be.taskmanager.domain.Task;

import java.util.List;

public interface TaskService {
	public List<Task> getTasks();

	Task getTask(int id);

	void addTask(Task task);

	void editTask(Task task);

	void addSubTask(int mainTaskId, Task task);

	List<Task> getSubTasks(int id);

//	void addRestaurant(RestaurantDTO restaurantDTO);
}
