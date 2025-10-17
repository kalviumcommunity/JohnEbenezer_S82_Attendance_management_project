package com.school;

public class Teacher extends Person implements Storable {
    private String subjectTaught;

    public Teacher(String name, String subjectTaught) {
        super(name);
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    @Override
    public void displayDetails() {
        System.out.println("Teacher ID: " + getId() + ", Name: " + getName() + ", Subject: " + subjectTaught);
    }

    @Override
    public String toFileString() {
        return getId() + "," + getName() + "," + subjectTaught + ",Teacher";
    }
}
