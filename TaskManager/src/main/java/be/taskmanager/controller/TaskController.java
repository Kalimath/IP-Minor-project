package be.taskmanager.controller;

import be.taskmanager.domain.Task;
import be.taskmanager.domain.TaskI;
import be.taskmanager.dto.SubTaskDTO;
import be.taskmanager.dto.TaskDTO;
import be.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
			model.addAttribute("subTasks", task.getSubTasks());
		}
		return "task";
	}

	@RequestMapping("/new")
	public String getTaskForm(Model model){
		model.addAttribute("task", new Task());
		return "taskForm";
	}



	@PostMapping("/newTask")
	public String addTask(@ModelAttribute TaskI task, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "taskform";
		}else{
			taskService.addTask((TaskDTO) task);
			return "redirect:/tasks";
		}

	}

	@RequestMapping("/edit/{id}")
	public String getTaskToEdit(@PathVariable int id, Model model){
		TaskI task = (TaskI) taskService.getTask(id);
		if(task==null){
			model.addAttribute("task", "Task not found");
		}else{
			model.addAttribute("task", task);
			editTask = id;
		}
		return "editTaskForm";
	}

	@PostMapping("/editTask")
	public String editTask(@ModelAttribute TaskI task){
		taskService.getTask(editTask).setTitle(task.getTitle());
		taskService.getTask(editTask).setDesc(task.getDesc());
		taskService.getTask(editTask).setDeadline(task.getDeadline());
		return "redirect:/tasks/"+editTask;
//		return "redirect:/tasks/"+(task.getId()-1);
	}

	@RequestMapping("/{id}/sub/create")
	public String createSubTask(@PathVariable("id") int id, Model model){
		TaskI task = (TaskI) taskService.getTask(id);
		TaskI subTask = new Task();
		if(task==null){
			model.addAttribute("taskId", "Task not found");
		}else{
			model.addAttribute("taskId", id);
			model.addAttribute("subtask",subTask);
		}
		return "subTaskForm";
	}

	@PostMapping("/addSubTask/{id}")
	public String addSubTask(@PathVariable int id, @ModelAttribute SubTaskDTO task, Model model){
		taskService.addSubTask(id,task);
		System.out.println(task.getTitle());
		return "redirect:/tasks/"+id;
	}

}
