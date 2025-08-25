/*Grade Calculator*
1. Input: Take marks obtained (out of 100) in each subject.
2. Calculate Total Marks: Sum up the marks obtained in all subjects.
3. Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
4. Grade Calculation: Assign grades based on the average percentage achieved.
5. Display Results: Show the total marks, average percentage, and the corresponding grade to the user */


package GradeCalculator;

public class GradeCalculation {
    public static String calculateGrade(int s1,int s2,int s3,int s4,int s5,int s6) {
        int totalmarks = s1 + s2 + s3 + s4 + s5+s6;
        int Avg  = totalmarks / 6;
        System.out.println("\nTotal Marks: " + totalmarks);
        System.out.println("\nAverage Marks: " + Avg);

        for(int i: new int[]{s1,s2,s3,s4,s5,s6}){
            if(i<0 || i>100){
                  return "Invalid Input! Marks should be between 0 and 100.";
            }else{
                if(i<40){
                    return "Fail";
                }
            }
        }   
        int score = Avg;
        if (score >= 95) {
            return "A++";
        }else if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }   
}

//     //Main function
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter marks of 5 subjects:");
//         System.out.println("\n(Note: Marks should be between 0 to 100)");
//         System.out.print("\nMarks in Hindi  :");
//         int s1 = sc.nextInt();
//         System.out.print("Marks in Maths :");
//         int s2 = sc.nextInt();
//         System.out.print("Marks in Science  :");
//         int s3 = sc.nextInt();
//         System.out.print("Marks in S.Science  :");
//         int s4 = sc.nextInt();
//         System.out.print("Marks in Sanskrit :");
//         int s5 = sc.nextInt();
//         System.out.print("Marks in English  :");
//         int s6 = sc.nextInt();
       
//         String grade = calculateGrade(s1, s2, s3, s4, s5, s6);
//         System.out.println("\nYour Grade is: " + grade);
//         sc.close();
//     }
// }
