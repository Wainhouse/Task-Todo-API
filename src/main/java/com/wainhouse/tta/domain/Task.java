package com.wainhouse.tta.domain;

public class Task {

    private Long id;
    private String task;
    private String dateAdded;
    private String dateCompleted;
    private String type;

    public Task(Long id, String task, String dateAdded, String dateCompleted, String type) {
        this.id = id;
        this.task = task;
        this.dateAdded = dateAdded;
        this.dateCompleted = dateCompleted;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Task [Task:" + task + ", Date Added:" + dateAdded + ", Date Completed:" + dateCompleted + ", Type:" + type + "]";
    }

}
