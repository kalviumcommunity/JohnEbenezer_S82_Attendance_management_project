package com.school;

import java.util.*;

public class RegistrationService {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private FileStorageService storageService;

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
    }

    // Registration methods
    public Student registerStudent(int id, String name, int gradeLevel) {
        Student s = new Student(id, name, gradeLevel);
        students.add(s);
        return s;
    }

    public Teacher registerTeacher(String name, String subject) {
        Teacher t = new Teacher(name, subject);
        teachers.add(t);
        return t;
    }

    public Staff registerStaff(String name, String role) {
        Staff st = new Staff(name, role);
        staffMembers.add(st);
        return st;
    }

    public Course createCourse(int id, String name) {
        Course c = new Course(id, name);
        courses.add(c);
        return c;
    }

    // Accessors
    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    // Lookup
    public Student findStudentById(int id) {
        for (Student s : students)
            if (s.getId() == id) return s;
        return null;
    }

    public Course findCourseById(int id) {
        for (Course c : courses)
            if (c.getCourseId() == id) return c;
        return null;
    }

    // Combined people list
    public List<Person> getAllPeople() {
        List<Person> all = new ArrayList<>();
        all.addAll(students);
        all.addAll(teachers);
        all.addAll(staffMembers);
        return all;
    }

    // Save all data
    public void saveAllRegistrations() {
        storageService.saveData(students, "students.txt");
        storageService.saveData(teachers, "teachers.txt");
        storageService.saveData(staffMembers, "staff.txt");
        storageService.saveData(courses, "courses.txt");
    }
}
