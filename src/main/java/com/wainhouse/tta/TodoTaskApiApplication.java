package com.wainhouse.tta;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wainhouse.tta.domain.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoTaskApiApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(TodoTaskApiApplication.class, args);

		ObjectMapper mapper = new ObjectMapper();

		Task demoTask = new Task(1L, "Do Laundry", "07.08", "08/08", "Urgent");

		String demoTaskAsJSON = mapper.writeValueAsString(demoTask);

		System.out.println(demoTaskAsJSON);

		Task backtoTask = mapper.readValue(demoTaskAsJSON, Task.class);

		System.out.println(backtoTask);
	}

	}
