package com.recruit.task.models;

import com.opencsv.bean.CsvBindByName;

public class Citizen extends Entity {

    @CsvBindByName
    private String surname;

    @CsvBindByName(column="parent_id")
    private long parentId;

    @CsvBindByName
    private String city;

    public Citizen(){}

    public Citizen(long id, String name, String surname, int age, String city, long parentId) {
        super(id, name, age);
        this.setSurname(surname);
        this.setParentId(parentId);
        this.setCity(city);
    }

    private void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getParentId() {
        return parentId;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        String base = super.toString();

        builder.append("Citizen from Warsaw : {\n")
                .append(base);

        builder.append("\nsurname = ")
                .append(surname)
                .append("\ncity = ")
                .append(city)
                .append("\nparent ID = ")
                .append(parentId)
                .append("\n}\n");

        return builder.toString();
    }
}
