package be.taskmanager.repository;
import be.taskmanager.domain.Task;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class TaskRepository {
	private List<Task> list;
	private HashMap<Integer,List<Task>> sublists;

	public TaskRepository() {
		list = new ArrayList<>();
		list.add(new Task("Examen IP Minor", "Lorem ipsum", LocalDateTime.of(2020, 07, 19,5,20)));
		list.add(new Task("Multimedia project afwerken", "Lorem ipsum", LocalDateTime.of(2020, 07, 19,20,50)));
		list.add(new Task("Communicatie indienen", "Lorem ipsum", LocalDateTime.of(2020, 06, 14,10,12)));

		sublists = new HashMap<>();
		addSubTask(0,new Task("Labo 1 IP Minor", "frameworks", LocalDateTime.of(2020, 07, 10,5,20)));
		addSubTask(1,new Task("Pointers", "weghalen", LocalDateTime.of(2020, 04, 10,5,20)));
		addSubTask(2,new Task("CV afwerken", "alles invullen", LocalDateTime.of(2020, 06, 10,5,20)));

	}

	public void addSubTask(int mainTaskId, Task task){
		if(sublists.get(mainTaskId)==null){
			sublists.put(mainTaskId,new ArrayList<>());
		}
		sublists.get(mainTaskId).add(task);
	}

	public List<Task> getTasks() {
		return list;
	}

	public void addTask(Task task) {
		list.add(task);
	}

	public Task getTask(int id){
		Task res = null;
		for (Task task :list) {
			if(task.getId() == id){
				res = task;
			}
		}
		return res;
	}

	public void update(Task task){
		this.getTask(task.getId()-1).update(task);
	}

	public List<Task> getSublist(int mainTaskId){
		return sublists.get(mainTaskId);
	}
}
