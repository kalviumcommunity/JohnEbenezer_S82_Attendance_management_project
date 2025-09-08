package com.school;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 10));
        students.add(new Student(2, "Bob", 11));
        students.add(new Student(3, "Charlie", 12));

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course(101, "Math"));
        courses.add(new Course(102, "Science"));
        courses.add(new Course(103, "History"));

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(1, 101, "Present"));
        records.add(new AttendanceRecord(2, 102, "Absent"));
        records.add(new AttendanceRecord(3, 103, "Present"));

        FileStorageService storageService = new FileStorageService();
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(records, "attendance_log.txt");

        System.out.println("Data saved successfully!");
    }
}
