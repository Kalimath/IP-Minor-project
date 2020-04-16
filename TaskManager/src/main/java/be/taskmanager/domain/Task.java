package be.taskmanager.domain;

import be.taskmanager.dto.TaskDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Task {
//    private static int ID=0;
    private int id;
    private String title, desc;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotEmpty
    @Id
    @GeneratedValue
    private LocalDateTime deadline;
    private ArrayList<TaskDTO> tasks;

    public Task(String title, String desc, LocalDateTime deadline){
        this.setTasks(new ArrayList<>());
        this.setTitle(title);
        this.setDesc(desc);
        this.setDeadline(deadline);
        System.out.println("description: "+desc);
//        id = ID++;
    }

    public Task(){
        this.setTasks(new ArrayList<>());
//        id = ID++;
    }

    public void setDeadline(LocalDateTime deadline){
        this.deadline = deadline;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setTasks(ArrayList<TaskDTO> tasks){
        this.tasks = tasks;
    }

    public ArrayList<TaskDTO> getTasks(){
        return tasks;
    }



    public String getTitle(){
        return title;
    }

    public LocalDateTime getDeadline(){
        return deadline;
    }

    @Override
    public String toString(){
        return title + ' ' + deadline.toLocalDate().toString() +' '+ deadline.toLocalTime().toString();
    }


    public int getId(){
        return id;
    }

    public String getDesc(){
        return desc;
    }

    public void update(Task task){
        this.title = task.title;
        this.desc = task.getDesc();
        this.deadline = task.getDeadline();
    }
}
