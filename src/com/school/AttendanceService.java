package com.school;

import java.util.*;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog = new ArrayList<>();
    private FileStorageService storageService;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.storageService = storageService;
        this.registrationService = registrationService;
    }

    // Direct object-based version
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // ID-based version (uses RegistrationService lookups)
    public void markAttendance(int studentId, int courseId, String status) {
        Student s = registrationService.findStudentById(studentId);
        Course c = registrationService.findCourseById(courseId);
        if (s != null && c != null) {
            markAttendance(s, c, status);
        } else {
            System.out.println("⚠️  Could not find Student or Course for attendance entry.");
        }
    }

    public void displayAttendanceLog() {
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        for (AttendanceRecord record : attendanceLog) {
            if (record.getStudentId() == student.getId()) {
                record.displayRecord();
            }
        }
    }

    public void displayAttendanceLog(Course course) {
        for (AttendanceRecord record : attendanceLog) {
            if (record.getCourseId() == course.getCourseId()) {
                record.displayRecord();
            }
        }
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
