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

        // Register people and courses
        regService.registerStudent(1, "Ram", 10);
        regService.registerStudent(2, "Sita", 11);
        regService.registerTeacher("Mr. Smith", "Math");
        regService.registerStaff("Mrs. Brown", "Administrator");

        regService.createCourse(101, "Full Stack Developer");
        regService.createCourse(102, "Data Science");

        // Display all
        displaySchoolDirectory(regService);

        // Mark attendance using ID-based method
        attendanceService.markAttendance(1, 101, "Present");
        attendanceService.markAttendance(2, 102, "Absent");

        // Display logs
        System.out.println("\n--- Attendance Log ---");
        attendanceService.displayAttendanceLog();

        // Save everything
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\n✅ Data saved successfully!");
    }
}
