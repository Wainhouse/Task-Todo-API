package com.wainhouse.tta.service;

import com.wainhouse.tta.domain.Task;

import java.util.List;

public interface TaskService {


    //CREATE
    Task createTask(Task newTask);

    //REad
    List<Task> getTasks();

    //READ
    Task getTask(Integer id);

    //UPDATE
    Task replaceTask(Integer id, Task newTask);

    //DELETE
    boolean removeTask(Integer id);


}
