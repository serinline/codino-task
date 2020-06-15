package controllers;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class DataLoader {

    public static <T> CsvToBean loadObjectsFromFile(Class type, String fileName) {
        Path myPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(myPath,
                StandardCharsets.UTF_8)) {
            HeaderColumnNameMappingStrategy<T> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(type);

            CsvToBean csvToBean = new CsvToBeanBuilder(br)
                    .withType(type)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
