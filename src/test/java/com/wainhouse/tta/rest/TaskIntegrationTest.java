package com.wainhouse.tta.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.wainhouse.tta.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest // boots the entire context
@AutoConfigureMockMvc // creates the MockMVC object for sending our test requests
public class TaskIntegrationTest {

    @Autowired
    private MockMvc mvc;

    // Too Long, Didn't Read:
    @Autowired
    private ObjectMapper mapper; // the EXACT SAME mapper that spring uses to convert objects to and from JSON

    @Test
    void testCreate() throws Exception {
        Task requestBody = new Task(1,"Do", "02/02", "03/02","Urgent");
        String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

        RequestBuilder request = post("/task/create").contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyAsJSON); // sets up the test request

        Task responseBody = new Task(1,"Do", "02/02", "03/02","Urgent");
        String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

        ResultMatcher checkStatus = status().isCreated(); // check the status code is 201
        ResultMatcher checkBody = content().json(responseBodyAsJSON); // check the body matches the example

        this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody); // performs request and checks the
        // response
    }
}