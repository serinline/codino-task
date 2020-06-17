package com.recruit.task.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Controller
public class DataLoader {

    public static <T> Stream loadObjectsFromFile(Class type, String fileName) {
        Path myPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(myPath,
                StandardCharsets.UTF_8)) {
            HeaderColumnNameMappingStrategy<T> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(type);

            return new CsvToBeanBuilder(br)
                    .withType(type)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse()
                    .stream();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
