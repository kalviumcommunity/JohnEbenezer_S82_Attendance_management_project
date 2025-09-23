package com.school;
import java.util.*;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("School Directory:");
        for (Person p : people) {
            p.displayDetails();
        }
    }

    public static void main(String[] args) {
        // --- Create Students ---
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ram", 10));
        students.add(new Student(2, "Sita", 11));
        students.add(new Student(3, "Lakshman", 12));
        students.add(new Student(4, "Hanuman", 9));

        // --- Add to school directory (Person list) ---
        List<Person> schoolPeople = new ArrayList<>(students);
        displaySchoolDirectory(schoolPeople);

        // --- Create Courses ---
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(101, "Full Stack Developer"));
        courses.add(new Course(102, "Data Science"));
        courses.add(new Course(103, "Cloud Computing"));
        courses.add(new Course(104, "Blockchain Development"));

        // --- Create Services ---
        FileStorageService storage = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storage);

        // --- Mark Attendance using both overloads ---
        attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
        attendanceService.markAttendance(students.get(1), courses.get(1), "Absent");

        attendanceService.markAttendance(3, 103, "Present", students, courses);
        attendanceService.markAttendance(4, 104, "Late", students, courses);

        // --- Display Logs ---
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(students.get(0));
        attendanceService.displayAttendanceLog(courses.get(1));

        // --- Save Data ---
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        attendanceService.saveAttendanceData();

        System.out.println("\nData saved successfully!");
    }
}
