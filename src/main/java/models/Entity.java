package models;

import com.opencsv.bean.CsvBindByName;

public class Entity {

    @CsvBindByName
    private long id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private int age;

    public Entity(){}

    Entity(long id, String name, int age){
        this.setId(id);
        this.setName(name);
        this.setAge(age);
    }

    private void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("id = ")
                .append(id)
                .append("\nname = ")
                .append(name)
                .append("\nage = ")
                .append(age);

        return builder.toString();
    }
}
