package StudentMgmtSystem;

import java.io.*;
import java.util.*;

// Base Person class (Inheritance Example)
public class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

// Student class extends Person (Inheritance + Encapsulation)
class Student extends Person {
    private int rollNumber;
    private String grade;
    private int age;

    public Student(String name, int rollNumber, String grade, int age) {
        super(name);
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.age = age;
    }

    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Roll: " + rollNumber + ", Name: " + name + ", Grade: " + grade + ", Age: " + age;
    }
}

// StudentManagementSystem (Aggregation + File Handling)
class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.csv"; // text file

    // Add Student
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    // Remove Student
    public void removeStudent(int rollNumber) {
        boolean removed = students.removeIf(s -> s.getRollNumber() == rollNumber);
        if (removed) {
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search Student
    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }

    // Display all students
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            students.forEach(System.out::println);
        }
    }

    // Save to CSV file
    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.getRollNumber() + "," + s.getName() + "," + s.getGrade() + "," + s.getAge());
            }
            System.out.println("Data saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load from CSV file
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println(" No saved data found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int roll = Integer.parseInt(data[0]);
                    String name = data[1];
                    String grade = data[2];
                    int age = Integer.parseInt(data[3]);
                    students.add(new Student(name, roll, grade, age));
                }
            }
            System.out.println("Data loaded from " + FILE_NAME);
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}

