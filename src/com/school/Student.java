package com.school;

public class Student extends Person {
    private String grade;

    public Student(int id, String name, int gradeLevel) {
        super(id, name);
        this.grade = "Grade " + gradeLevel;
    }

    public Student(String name, String grade) {
        super(name); // auto-generate ID
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + getId() + ", Name: " + getName() + ", Grade: " + grade);
    }

    @Override
    public String toFileString() {
        return getId() + "," + getName() + "," + grade;
    }
}
