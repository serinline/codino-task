package com.recruit.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repositories.ActionService;



@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);

		String[] s = {"src/files/ludzie_w_warszawie.csv", "6"};
		ActionService.execute(s);

	}

}
