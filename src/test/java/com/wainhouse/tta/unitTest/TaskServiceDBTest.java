package com.wainhouse.tta.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import com.wainhouse.tta.domain.Task;
import com.wainhouse.tta.repos.TaskRepo;
import com.wainhouse.tta.service.TaskService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class TaskServiceDBTest {

    @Autowired //injecting
    private TaskService service;

    @MockBean //Creating a mock repo and injecting it
    private TaskRepo repo;


    //GIVEN > WHEN > THEN > FINAL

    @Test //Create Method
    void testCreateTask() {

        //Given
        Task newTask = new Task("Eat Apple", "02/11/2021", "03/11/2021", "Moderate");
        Task savedTask = new Task(1, "Eat Apple", "02/11/2021", "03/11/2021", "Moderate");

        //When
        Mockito.when(this.repo.save(newTask)).thenReturn(savedTask);


        //Then
        Assertions.assertThat(this.service.createTask(newTask)).isEqualTo(savedTask);

        //Final
        Mockito.verify(this.repo, Mockito.times(1)).save(newTask);
    }

    @Test // READ all
    void testGetTasks() {

        //GIVEN
        Task testGetAllTasks = new Task(1, "Eat Apple", "02/11/2021", "03/11/2021", "Moderate");
        testGetAllTasks.setId(1);
        //Creating list
        List<Task> taskList = List.of(testGetAllTasks);

        //WHEN
        Mockito.when(this.repo.findAll()).thenReturn(taskList);

        //THEN
        Assertions.assertThat(this.service.getTasks()).isEqualTo(taskList);

        //Verify
        Mockito.verify(this.repo, Mockito.times(1)).findAll();

    }

    @Test // READ by ID
    void testGetTask() {
        Task expectedTask = new Task(1,"Eat Apple", "02/11/2021", "03/11/2021", "Moderate");;

        //WHEN
        Mockito.when(this.repo.findById(1)).thenReturn(Optional.of(expectedTask));

        //THEN
        Assertions.assertThat(this.service.getTask(1)).isEqualTo(expectedTask);

        //Verify
        Mockito.verify(this.repo, Mockito.times(1)).findById(1);
    }



}
