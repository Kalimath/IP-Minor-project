package be.taskmanager.controller;

import be.taskmanager.domain.Task;
import be.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	private final TaskService taskService;

	@Autowired
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
		Task task = taskService.getTask(id);
		if(task==null){
			model.addAttribute("task", "Task not found");
		}else{
			model.addAttribute("task", task);
			model.addAttribute("subTasks", taskService.getSubTasks(id));
		}
		return "task";
	}

	@RequestMapping("/new")
	public String getTaskForm(Model model){
		return "taskForm";
	}



	@PostMapping("/newTask")
	public String addTask(@ModelAttribute Task task){
		taskService.addTask(task);
		return "redirect:/tasks";
	}

	@RequestMapping("/edit/{id}")
	public String getTaskToEdit(@PathVariable int id, Model model){
		Task task = taskService.getTask(id);
		if(task==null){
			model.addAttribute("task", "Task not found");
		}else{
			model.addAttribute("task", task);
		}
		return "editTaskForm";
	}

	@PostMapping("/editTask")
	public String editTask(@ModelAttribute Task task){
		taskService.editTask(task);
		return "redirect:/tasks/"+(task.getId()-1);
	}

	@RequestMapping("/{id}/sub/create")
	public String createSubTask(@PathVariable("id") int id, Model model){
		Task task = taskService.getTask(id);
		if(task==null){
			model.addAttribute("taskId", "Task not found");
		}else{
			model.addAttribute("taskId", id);
		}
		return "subTaskForm";
	}

	@PostMapping("/addSubTask/{id}")
	public String addSubTask(@PathVariable int id, @ModelAttribute Task task, Model model){
		taskService.addSubTask(id, task);
		System.out.println(task.getId());
		return "redirect:/tasks/"+id;
	}

}
