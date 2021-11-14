package com.wainhouse.tta.Service;


import com.wainhouse.tta.domain.Task;
import com.wainhouse.tta.repos.TaskRepo;
import com.wainhouse.tta.service.TaskService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskServiceDBTest {

    @Autowired //injecting
    private TaskService service;

    @MockBean //Creating a mock repo and injecting it
    private TaskRepo repo;


    //GIVEN(G) > WHEN(W) > THEN (T)> FINAL(F)

    @Test
        //Create Method
    void testCreateTask() {

        //G
        Task newTask = new Task("Eat Apple", "02/11/2021", "03/11/2021", "Moderate");
        Task savedTask = new Task(1, "Eat Apple", "02/11/2021", "03/11/2021", "Moderate");

        //W
        Mockito.when(this.repo.save(newTask)).thenReturn(savedTask);


        //T
        Assertions.assertThat(this.service.createTask(newTask)).isEqualTo(savedTask);

        //F
        Mockito.verify(this.repo, Mockito.times(1)).save(newTask);
    }

    @Test // READ all
    void testGetTasks() {

        //G
        Task testGetAllTasks = new Task(1, "Eat Apple", "02/11/2021", "03/11/2021", "Moderate");
        testGetAllTasks.setId(1);
        //Creating list
        List<Task> taskList = List.of(testGetAllTasks);

        //W
        Mockito.when(this.repo.findAll()).thenReturn(taskList);

        //T
        Assertions.assertThat(this.service.getTasks()).isEqualTo(taskList);

        //F
        Mockito.verify(this.repo, Mockito.times(1)).findAll();

    }

    @Test // fetch by ID
    void testGetTask() {
        Task expectedCustomerAccount = new Task("Eat Apple", "02/11/2021", "03/11/2021", "Moderate");

        //W
        Mockito.when(this.repo.findById(1)).thenReturn(Optional.of(expectedCustomerAccount));

        //T
        Assertions.assertThat(this.service.getTask(1)).isEqualTo(expectedCustomerAccount);

        //F
        Mockito.verify(this.repo, Mockito.times(1)).findById(1);
    }


    @Test // Remove method
    void testRemoveTask() {

        //W
        Mockito.when(this.repo.existsById(1)).thenReturn(false);

        //T
        Assertions.assertThat(this.service.removeTask(1)).isTrue();

        //F
        Mockito.verify(this.repo, Mockito.times(1)).deleteById(1);

    }

}
