package com.school;

public class Course implements Storable {
    private int courseId;
    private String courseName;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName;
    }
}
