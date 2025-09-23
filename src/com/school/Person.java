package com.school;

public abstract class Person implements Storable {
    private int id;
    private String name;

    // Constructor with id + name
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor with only name (auto-generate id)
    public Person(String name) {
        this.id = new java.util.Random().nextInt(1000);
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();

    @Override
    public String toFileString() {
        return id + "," + name;
    }
}
