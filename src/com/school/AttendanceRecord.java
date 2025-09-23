package com.school;

public class AttendanceRecord implements Storable {
    private int studentId;
    private int courseId;
    private String status;

    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
    }

    public AttendanceRecord(Student student, Course course, String status) {
        this.studentId = student.getId();
        this.courseId = course.getCourseId();
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Student ID: " + studentId + ", Course ID: " + courseId + ", Status: " + status);
    }

    @Override
    public String toFileString() {
        return studentId + "," + courseId + "," + status;
    }
}
