package be.taskmanager.domain;

import be.taskmanager.dto.SubTaskDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
public class Task implements TaskI {
//    private static int ID=0;
    @Id
    @GeneratedValue
    private int id;
    private String title, desc;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime deadline;

    private ArrayList<SubTaskDTO> subTasks;

    public Task(String title, String desc, LocalDateTime deadline){
        this.setSubTasks(new ArrayList<>());
        this.setTitle(title);
        this.setDesc(desc);
        this.setDeadline(deadline);
        System.out.println("description: "+desc);
//        id = ID++;
    }

    public Task(){
        this.setSubTasks(new ArrayList<>());
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

    public void setSubTasks(ArrayList<SubTaskDTO> subTasks){
        this.subTasks = subTasks;
    }

    public ArrayList<SubTaskDTO> getSubTasks(){
        return subTasks;
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

    /*public void update(Task task){
        this.title = task.title;
        this.desc = task.getDesc();
        this.deadline = task.getDeadline();
    }*/
}
