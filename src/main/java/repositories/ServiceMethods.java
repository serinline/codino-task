package repositories;

import com.opencsv.bean.CsvToBean;

import java.util.List;
import java.util.stream.Stream;

public class ServiceMethods {

    public static void print_objects(int value){
        switch (value){
            case 1:

            case 2:

            case 3:

            case 4:

        }
    }

    public static <T> void printFirstTenElements(CsvToBean csvToBean){
        Stream objects = csvToBean.parse().stream();
        objects.limit(10).forEach(System.out::println);
    }


}
