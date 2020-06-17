package com.recruit.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.recruit.task.repositories.ActionService;


@SpringBootApplication
public class TaskApplication {
	static String s1 = "src/files/ludzie_w_warszawie.csv";
	String s2 = "src/files/psy_schronisko_01.csv";
	String s3 = "src/files/psy_schronisko_02.csv";
	String s4 = "src/files/rowerzysci_lista_startowa.csv";
	String s5 = "src/files/rowerzysci_zawody.csv";

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class);
		ActionService.execute(args);
	}

}
