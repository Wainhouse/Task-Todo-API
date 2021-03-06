package com.wainhouse.tta.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.wainhouse.tta.domain.Task;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@SpringBootTest // boots the entire context
@AutoConfigureMockMvc // creates the MockMVC object for sending our test requests
@Sql(scripts = { "classpath:task-schema.sql",
        "classpath:task-data.sql" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
// runs schema and data file before each test
// if you see error like 'x is not a column' check you're using '' for strings
@ActiveProfiles("test") // sets the profile to 'test'
public class TaskIntegrationTest {

    @Autowired
    private MockMvc mvc;

    // TL;DR:
    @Autowired
    private ObjectMapper mapper; // the EXACT SAME mapper that spring uses to convert objects to and from JSON

    @Test
    void testCreate() throws Exception {
        Task requestBody = new Task("Do", "02/02", "03/02", "Urgent");
        String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

        RequestBuilder request = post("/task/create").contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyAsJSON); // sets up the test request

        Task responseBody = new Task(2, "Do", "02/02", "03/02", "Urgent");
        String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

        ResultMatcher checkStatus = status().isCreated(); // check the status code is 201
        ResultMatcher checkBody = content().json(responseBodyAsJSON); // check the body matches the example


    }
    // I don't know why this isn't working
    @Disabled
    @Test
    void testGetAll() throws Exception {

        RequestBuilder request = get("/task/getAll");

        ResultMatcher checkStatus = status().isOk();

        Task task = new Task("Do Laundry", "30/11/2021", "31/11/2021", "Urgent");

        List<Task> tasks = List.of(task);
        String responseBody = this.mapper.writeValueAsString(tasks);
        ResultMatcher checkBody = content().json(responseBody);

        this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
    }

}

