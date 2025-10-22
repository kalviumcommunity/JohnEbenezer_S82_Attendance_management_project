package com.school;

public class Main {

    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        for (Person p : regService.getAllPeople()) {
            p.displayDetails();
        }
        System.out.println("-------------------------\n");
    }

    public static void main(String[] args) {
        FileStorageService storage = new FileStorageService();
        RegistrationService regService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        // Register entities
        Student s1 = regService.registerStudent(1, "Ram", 10);
        Student s2 = regService.registerStudent(2, "Sita", 11);
        Student s3 = regService.registerStudent(3, "Lakshman", 12);
        regService.registerTeacher("Mr. Smith", "Math");
        regService.registerStaff("Mrs. Brown", "Administrator");

        // Create courses with capacities
        Course c1 = regService.createCourse(101, "Full Stack Developer", 2);
        Course c2 = regService.createCourse(102, "Data Science", 1);

        // Enroll students
        regService.enrollStudentInCourse(s1, c1);
        regService.enrollStudentInCourse(s2, c1);
        regService.enrollStudentInCourse(s3, c1); // exceeds capacity

        regService.enrollStudentInCourse(s1, c2);
        regService.enrollStudentInCourse(s2, c2); // exceeds capacity

        // Display courses with capacity and enrolled counts
        System.out.println("\n--- Course Details ---");
        for (Course course : regService.getCourses()) {
            course.displayDetails();
        }

        // Mark attendance (only if enrolled)
        System.out.println("\n--- Attendance ---");
        attendanceService.markAttendance(1, 101, "Present");
        attendanceService.markAttendance(2, 101, "Absent");
        attendanceService.markAttendance(3, 102, "Present"); // not enrolled, just for demonstration

        // Display attendance log
        attendanceService.displayAttendanceLog();

        // Save all data
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\n Data saved successfully!");
    }
}
