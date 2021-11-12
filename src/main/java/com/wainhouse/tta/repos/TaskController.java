package com.wainhouse.tta.repos;

import com.wainhouse.tta.domain.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @GetMapping("/hello") // listening for hello world (Testing)
    public String hello() {
        return "Hello, World!"; //response
    }
    //CREATE
    @PostMapping("/create") // triggered by a POST request to /create
    public ResponseEntity<Task> createTask(@RequestBody Task newTask) { // a task object in the request + response
        // body
        this.tasks.add(newTask);
        Task responseBody = this.tasks.get(this.tasks.size() - 1); //
        return new ResponseEntity<Task>(responseBody, HttpStatus.CREATED);
    }
    //RETURN
    @GetMapping("/getAll") //return a list of tasks
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(this.tasks);
    }
    //RETURN
    @GetMapping("/get/{id}") // return task with id of {id}
    public Task getTask(@PathVariable Integer id) {
        return this.tasks.get(id);
    }
    //UPDATE
    @PutMapping("/replace/{id}") // replace task
    public ResponseEntity<Task> replaceTask(@PathVariable Integer id, @RequestBody Task newTask) {

        System.out.println("Replacing task with id " + id + " with " + newTask);
        return null;
    }
    //DELETE
//    @DeleteMapping("/remove/{id}" // delete task
//    public ResponseEntity<?> removeTask(@PathVariable Integer id) {
//        System.out.println("Removing task with id " + id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
