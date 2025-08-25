package GradeCalculator;

import java.util.Scanner;

public class StudentGradeCal {
        //Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks of 5 subjects:");
        System.out.println("\n(Note: Marks should be between 0 to 100)");
        System.out.print("\nMarks in Hindi  :");
        int s1 = sc.nextInt();
        System.out.print("Marks in Maths :");
        int s2 = sc.nextInt();
        System.out.print("Marks in Science  :");
        int s3 = sc.nextInt();
        System.out.print("Marks in S.Science  :");
        int s4 = sc.nextInt();
        System.out.print("Marks in Sanskrit :");
        int s5 = sc.nextInt();
        System.out.print("Marks in English  :");
        int s6 = sc.nextInt();
       
        String grade = GradeCalculation.calculateGrade(s1, s2, s3, s4, s5, s6);
        System.out.println("\nYour Grade is: " + grade);
        sc.close();
    }
    
}
