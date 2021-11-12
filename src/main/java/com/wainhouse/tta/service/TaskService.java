package com.wainhouse.tta.service;

import com.wainhouse.tta.domain.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task newTask);

    List<Task> getTasks();

    Task getTask(Integer id);

    Task replaceTask(Integer id, Task newTask);

    boolean removeTask(Integer id);


}
