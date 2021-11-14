package com.wainhouse.tta;


import com.wainhouse.tta.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TodoTaskApiApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ac = SpringApplication.run(TodoTaskApiApplication.class, args);

		TaskService service = ac.getBean(TaskService.class);

		System.out.println(service);
	}

}