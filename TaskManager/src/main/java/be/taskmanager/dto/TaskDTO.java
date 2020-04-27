package be.taskmanager.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskDTO {

    private String desc;
    private String title;
    ArrayList<SubTaskDTO> subTasks;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public LocalDateTime deadline;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<SubTaskDTO> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(ArrayList<SubTaskDTO> subTasks) {
        this.subTasks = subTasks;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }


}

