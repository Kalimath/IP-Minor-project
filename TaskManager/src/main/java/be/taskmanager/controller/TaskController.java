package be.taskmanager.controller;

import be.taskmanager.domain.Task;
import be.taskmanager.dto.TaskDTO;
import be.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	private int editTask;
	@Autowired
	private final TaskService taskService;
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
	public String getTasks(Model model){
		model.addAttribute("tasks", taskService.getTasks());
		return "tasks";
	}

	@RequestMapping("/{id}")
	public String getTask(@PathVariable int id, Model model){
		TaskDTO task = taskService.getTask(id);
		if(task==null){
			model.addAttribute("task", "Task not found");
		}else{
			model.addAttribute("task", task);
			model.addAttribute("subTasks", task.getTasks());
		}
		return "task";
	}

	@RequestMapping("/new")
	public String getTaskForm(Model model){
		return "taskForm";
	}



	@PostMapping("/newTask")
	public String addTask(@ModelAttribute TaskDTO task){
		taskService.addTask(task);
		return "redirect:/tasks";
	}

	@RequestMapping("/edit/{id}")
	public String getTaskToEdit(@PathVariable int id, Model model){
		TaskDTO task = taskService.getTask(id);
		if(task==null){
			model.addAttribute("task", "Task not found");
		}else{
			model.addAttribute("task", task);
			editTask = id;
		}
		return "editTaskForm";
	}

	@PostMapping("/editTask")
	public String editTask(@ModelAttribute Task task){
		taskService.getTask(editTask).setName(task.getTitle());
		taskService.getTask(editTask).setDescription(task.getDesc());
		taskService.getTask(editTask).setTime(task.getDeadline());
		return "redirect:/tasks/"+editTask;
//		return "redirect:/tasks/"+(task.getId()-1);
	}

	@RequestMapping("/{id}/sub/create")
	public String createSubTask(@PathVariable("id") int id, Model model){
		TaskDTO task = taskService.getTask(id);
		Task subTask = new Task();
		if(task==null){
			model.addAttribute("taskId", "Task not found");
		}else{
			model.addAttribute("taskId", id);
			model.addAttribute("subtask",subTask);
		}
		return "subTaskForm";
	}

	@PostMapping("/addSubTask/{id}")
	public String addSubTask(@PathVariable int id, @ModelAttribute TaskDTO task, Model model){
		taskService.getTask(id).addSubTask(task);
		System.out.println(task.getName());
		return "redirect:/tasks/"+id;
	}

}
