package repositories;

import models.Entity;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;


class ServiceMethods {

    private static Stream objects;
    private static int secArg;

    ServiceMethods(Stream s){
        this.setObjects(s);
    }

    ServiceMethods(Stream s, int secArg){
        this.setObjects(s);
        this.setSecArg(secArg);
    }

    void print_objects(int value){
        switch (value){
            case 1:
                printFirstTenElements(objects);
            case 2:
                printNumberOfElements(calculateNumberOfElements(objects));
            case 3:
                printValuesWithSpecificIds(objects, secArg);
            case 4:
                printMapWithSpecificValues(countNames(objects), 100);
        }
    }

    private void setObjects(Stream s){
        objects = s;
    }

    private void setSecArg(int sec){
        secArg = sec;
    }

    private static void printFirstTenElements(Stream s){
        s.limit(10).forEach(System.out::println);
    }

    private static long calculateNumberOfElements(Stream s){
        return s.count();
    }

    private static void printNumberOfElements(long value){
        System.out.println("There are " + value + " elements in file.");
    }

    private static void printValuesWithSpecificIds(Stream s, long id){
        s.filter(Entity.class::isInstance).filter(c -> ((Entity) c).getId() > id).forEach(System.out::println);
    }

    private static Map<? extends Entity, Integer> countNames(Stream s){
        return (Map<? extends Entity, Integer>) s
                .collect(groupingBy(Entity::getName, Collectors.counting()));
    }

    private static void printMapWithSpecificValues(Map<? extends Entity, Integer> map, int quantity){
        map.forEach((key, value) -> {
            if(value > quantity)
            System.out.println("Name: " + key.getName() + " : " + value);
        });
    }


}
