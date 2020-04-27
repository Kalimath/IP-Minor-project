package be.taskmanager.domain;

import be.taskmanager.dto.TaskDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

@Entity
public class SubTask implements TaskI {
    @Id
    @GeneratedValue
    private int id;
    private String title, desc;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime deadline;

    public SubTask(String title, String desc, LocalDateTime deadline){
        this.setTitle(title);
        this.setDesc(desc);
        this.setDeadline(deadline);
    }

    public SubTask(){

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

}

