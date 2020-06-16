package repositories;

import models.Entity;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
                break;
            case 2:
                printNumberOfElements(calculateNumberOfElements(objects));
                break;
            case 3:
                printValuesWithSpecificIds(objects, secArg);
                break;
            case 4:
                printMapWithSpecificValues(countNames(objects), 100);
                break;
            case 5:
                printAverage(calculateAverage(objects));
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
                .collect(Collectors.groupingBy(Entity::getName, Collectors.counting()));
    }

    private static void printMapWithSpecificValues(Map<? extends Entity, Integer> map, int frequency) {
        for (Map.Entry<? extends Entity, Integer> entry : map.entrySet()) {
            if (Integer.parseInt(String.valueOf(entry.getValue())) > frequency)
                System.out.println("Name: " + entry.getKey() + ", frequency : " + entry.getValue());
        }
    }

    private static double calculateAverage(Stream s){
        return s.filter(Entity.class::isInstance)
                .mapToDouble(x -> ((Entity) x).getAge())
                .average()
                .getAsDouble();
    }

    private static void printAverage(double avg){
        System.out.println("Average of elements is: " + avg);
    }
}
