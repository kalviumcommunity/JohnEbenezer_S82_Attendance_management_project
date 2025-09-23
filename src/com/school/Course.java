package com.school;

public class Course implements Storable {
    private int courseId;
    private String courseName;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Course(String courseName) {
        this.courseId = new java.util.Random().nextInt(1000);
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: " + courseId + ", Name: " + courseName);
    }

    @Override
    public String toFileString() {
        return courseId + "," + courseName;
    }
}
