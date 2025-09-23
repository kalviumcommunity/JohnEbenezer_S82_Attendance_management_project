package com.school;

public class Staff extends Person {
    private String role;

    public Staff(String name, String role) {
        super(name);
        this.role = role;
    }

    @Override
    public void displayDetails() {
        System.out.println("Staff ID: " + getId() + ", Name: " + getName() +
                           ", Role: " + role);
    }

    @Override
    public String toFileString() {
        return getId() + "," + getName() + "," + role + ",Staff";
    }
}
