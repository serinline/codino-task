package com.recruit.task.models;

import com.opencsv.bean.CsvBindByName;

public class Cyclist extends Entity {

    @CsvBindByName
    private String city;

    @CsvBindByName
    private String record;

    @CsvBindByName(column="parent_id")
    private long parentId;

    public Cyclist(){}

    public Cyclist(long id, String name, int age, String city) {
        super(id, name, age);
        this.setCity(city);
    }

    public Cyclist(long id, String name, String record, int age, long parentId) {
        super(id, name, age);
        this.setRecord(record);
        this.setParentId(parentId);
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    private void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getParentId() {
        return parentId;
    }

    void setRecord(String record){
        this.record = record;
    }

    public String getRecord(){
        return record;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        String base = super.toString();

        builder.append("Cyclist : {\n")
                .append(base);

        if (city != null) {
            builder.append("\ncity = ")
                    .append(city)
                    .append("\n}\n");
        } else {
            builder.append("\nrecord = ")
                    .append(record)
                    .append("\nparent ID = ")
                    .append(parentId)
                    .append("\n}\n");
        }
        return builder.toString();
    }
}
