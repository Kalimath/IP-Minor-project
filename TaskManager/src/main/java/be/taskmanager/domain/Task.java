package be.taskmanager.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
    private static int ID=0;
    private int id;
    private String title, desc;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime deadline;

    public Task(String title, String desc, LocalDateTime deadline){
        this.title = title;
        this.desc = desc;
        System.out.println("description: "+desc);
        this.deadline = deadline;
        id = ID++;
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
