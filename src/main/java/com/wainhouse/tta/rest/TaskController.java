package com.wainhouse.tta.rest;

import com.wainhouse.tta.domain.Task;
import com.wainhouse.tta.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task")
public class TaskController {

    private TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        super();
        this.service = service;
    }

    @GetMapping("/hello") // listening for hello world (Testing)
    public String hello() {
        return "Hello, World!"; //response
    }


    //CREATE
    @PostMapping("/create") // triggered by a POST request to /create
    public ResponseEntity<Task> createTask(@RequestBody Task newTask) { // a task object in the request + response
       Task responseBody = this.service.createTask(newTask);
        return new ResponseEntity<Task>(responseBody, HttpStatus.CREATED);
    }


    //RETURN
    @GetMapping("/getAll") //return a list of tasks
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(this.service.getTasks());
    }


    //RETURN
    @GetMapping("/get/{id}") // return task with id of {id}
    public Task getTask(@PathVariable Integer id) {
        return this.service.getTask(id);
    }
    //UPDATE
    @PutMapping("/replace/{id}") // replace task
    public ResponseEntity<Task> replaceTask(@PathVariable Integer id, @RequestBody Task newTask) {
        System.out.println("Replacing task with id " + id + " with " + newTask);
        Task body = this.service.replaceTask(id, newTask);
        return new ResponseEntity<Task>(body, HttpStatus.ACCEPTED);

    }


    //DELETE
    @DeleteMapping("/remove/{id}")// delete task
    public ResponseEntity<?> removeTask(@PathVariable Integer id) {
        System.out.println("Removing task with id " + id);
        boolean removed = this.service.removeTask(id);
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
