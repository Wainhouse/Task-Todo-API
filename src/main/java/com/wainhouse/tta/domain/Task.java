package com.wainhouse.tta.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {


    //Attributes
    @Id // This is a PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto
    private Integer id;
    private String task;
    private String dateAdded;
    private String dateCompleted;
    private String type;

    //Constructors
    public Task(Integer id, String task, String dateAdded, String dateCompleted, String type) {
        super();
        this.id = id;
        this.task = task;
        this.dateAdded = dateAdded;
        this.dateCompleted = dateCompleted;
        this.type = type;
    }

    public Task(String task, String dateAdded, String dateCompleted, String type) {
        super();
        this.task = task;
        this.dateAdded = dateAdded;
        this.dateCompleted = dateCompleted;
        this.type = type;
    }



    public Task() {
        super();
    }


    //Getter and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
