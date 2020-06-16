package com.recruit.task;

import com.opencsv.bean.CsvToBean;
import controllers.DataLoader;

import models.Citizen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repositories.ActionService;



@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
		ActionService.execute(args);

	}


}
