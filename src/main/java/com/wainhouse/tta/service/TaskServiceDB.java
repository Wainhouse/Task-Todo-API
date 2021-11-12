package com.wainhouse.tta.service;

import com.wainhouse.tta.domain.Task;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceDB implements TaskService {

//    @Override //No longer needed
//    public Task createTask(Task newTask) {
//
//        return null;
//    }
    private TaskRepo repo;

    public TaskServiceDB(TaskRepo repo) {
        super();
        this.repo = repo;
    }
    
    @Override
    public Task createTask(Task newTask) {
        return this.repo.save(newTask);
    }

    @Override
    public List<Task> getTasks() {
        return this.repo.findAll();
    }

    @Override
    public Task getTask(Integer id) {
        Optional<Task> taskOptional = this.repo.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            return task;
        } else {
            throw new EntityNotFoundException("No task found with id: " + id);
        }
    }

    @Override
    public Task replaceTask(Integer id, Task newTask) {
        Task existing = this.getTask(id);

        existing.setTask(newTask.getTask(););
        existing.setDateAdded(newTask.getDateAdded());
        existing.setDateCompleted(newTask.getDateCompleted());
        existing.setType(newTask.getType());

        return this.repo.save(existing);
    }

    @Override
    public boolean removeTask(Integer id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }

}
