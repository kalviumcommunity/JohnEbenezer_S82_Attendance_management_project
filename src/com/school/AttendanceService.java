package com.school;

import java.util.*;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    // --- Public Methods ---

    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    public void markAttendance(int studentId, int courseId, String status, 
                               List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("Error: Student or Course not found.");
        }
    }

    public void displayAttendanceLog() {
        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\n--- Attendance Log for Student: " + student.getName() + " ---");
        for (AttendanceRecord record : attendanceLog) {
            if (record.getStudentId() == student.getId())

 {
                record.displayRecord();
            }
        }
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\n--- Attendance Log for Course: " + course.getCourseName() + " ---");
        for (AttendanceRecord record : attendanceLog) {
            if (record.getCourseId() == course.getCourseId())
 {
                record.displayRecord();
            }
        }
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }

    // --- Helper Methods ---
    private Student findStudentById(int studentId, List<Student> students) {
        for (Student s : students) {
            if (s.getId() == studentId) {
                return s;
            }
        }
        return null;
    }

    private Course findCourseById(int courseId, List<Course> courses) {
        for (Course c : courses) {
            if (c.getCourseId() == courseId) {
                return c;
            }
        }
        return null;
    }
}
