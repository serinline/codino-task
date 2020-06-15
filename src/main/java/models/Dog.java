package models;

import com.opencsv.bean.CsvBindByName;

public class Dog extends Entity {

    @CsvBindByName
    private String vaccine;

    @CsvBindByName
    private String owner;

    @CsvBindByName(column="parent_id")
    private long parentId;

    public Dog(){}

    public Dog(long id, String name, int age, String vaccine, long parentId) {
        super(id, name, age);
        this.setVaccine(vaccine);
        this.setParentId(parentId);
    }

    public Dog(long id, String name, int age,String owner) {
        super(id, name, age);
        this.setOwner(owner);
    }

//    public static Dog dogWithVaccineAndParentID(long id, String name, int age, boolean vaccine, long parentId){
//        return new Dog(id, name, age, vaccine, parentId);
//    }
//
//    public static Dog dogWithOwner(long id, String name, int age, String owner){
//        return new Dog(id, name, age, owner);
//    }

    private void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getParentId() {
        return parentId;
    }

    public String getVaccine() {
        return vaccine;
    }

    private void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getOwner() {
        return owner;
    }

    private void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        String base = super.toString();

        builder.append("Dog : {\n")
                .append(base);

        if (owner != null) {
            builder.append("\nowner = ")
                    .append(owner)
                    .append("\n}\n");
        } else {
            builder.append("\nvaccine = ")
                    .append(vaccine)
                    .append("\nparent ID = ")
                    .append(parentId)
                    .append("\n}\n");
        }
        return builder.toString();
    }
}
