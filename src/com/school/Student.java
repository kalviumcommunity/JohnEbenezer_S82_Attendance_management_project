package com.school;

public class Student implements Storable {
    private int id;
    private String name;
    private int gradeLevel;

    public Student(int id, String name, int gradeLevel) {
        this.id = id;
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    @Override
    public String toDataString() {
        return id + "," + name + "," + gradeLevel;
    }
}
