package be.taskmanager.dto;

import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskDTO {

    private String description;
    private String name;
    ArrayList<TaskDTO> tasks;

    @NotEmpty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public LocalDateTime time;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void addSubTask(TaskDTO task)
    {
        tasks.add(task);
    }
}

