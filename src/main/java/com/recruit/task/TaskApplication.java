package com.recruit.task;

import com.opencsv.bean.CsvToBean;
import controllers.DataLoader;
import models.Citizen;
import models.Cyclist;
import models.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.List;


@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);

		CsvToBean list = DataLoader.loadObjectsFromFile(Dog.class, "src/files/psy_schronisko_02.csv");
	}


}
