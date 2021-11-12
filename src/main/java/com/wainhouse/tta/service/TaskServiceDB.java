package com.wainhouse.tta.service;

import com.wainhouse.tta.domain.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceDB implements TaskService {

    @Override
    public Task createTask(Task newTask) {

        return null;
    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public Task getTask(Integer id) {
        return null;
    }

    @Override
    public Task replaceTask(Integer id, Task newTask) {
        return null;
    }

    @Override
    public boolean removeTask(Integer id) {
        return false;
    }

}
