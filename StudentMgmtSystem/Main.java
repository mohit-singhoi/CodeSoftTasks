package StudentMgmtSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner wrapped in try-with-resources
        try (Scanner sc = new Scanner(System.in)) {
            StudentManagementSystem sms = new StudentManagementSystem();
            sms.loadFromFile();

            while (true) {
                System.out.println("\n===== Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Search Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Save & Exit");
                System.out.print("\nEnter choice: ");

                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter Roll Number: ");
                            int roll = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();
                            if (name.isEmpty()) {
                                System.out.println("Name cannot be empty.");
                                break;
                            }
                            System.out.print("Enter Grade: ");
                            String grade = sc.nextLine();
                            System.out.print("Enter Age: ");
                            int age = Integer.parseInt(sc.nextLine());

                            Student s = new Student(name, roll, grade, age);
                            sms.addStudent(s);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format!");
                        }
                        break;

                    case 2:
                        System.out.print("Enter Roll Number to remove: ");
                        try {
                            int r = Integer.parseInt(sc.nextLine());
                            sms.removeStudent(r);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid roll number.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Roll Number to search: ");
                        try {
                            int sr = Integer.parseInt(sc.nextLine());
                            Student found = sms.searchStudent(sr);
                            if (found != null) {
                                System.out.println("Found: " + found);
                            } else {
                                System.out.println("Student not found.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid roll number.");
                        }
                        break;

                    case 4:
                        sms.displayAll();
                        break;

                    case 5:
                        sms.saveToFile();
                        System.out.println("Exiting...");
                        return; // exits program safely

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } // Scanner will be auto-closed here
    }
}
