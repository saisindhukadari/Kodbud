import java.util.Scanner;

class Student {
    String name;
    int marks1, marks2, marks3;
    double average;
    char grade;

    void inputDetails(Scanner sc) {
        System.out.print("Enter student name: ");
        sc.nextLine(); // clear buffer
        name = sc.nextLine();

        System.out.print("Enter marks in Subject 1: ");
        marks1 = sc.nextInt();

        System.out.print("Enter marks in Subject 2: ");
        marks2 = sc.nextInt();

        System.out.print("Enter marks in Subject 3: ");
        marks3 = sc.nextInt();
    }

    void calculateGrade() {
        average = (marks1 + marks2 + marks3) / 3.0;

        if (average >= 80)
            grade = 'A';
        else if (average >= 60)
            grade = 'B';
        else if (average >= 40)
            grade = 'C';
        else
            grade = 'F';
    }

    void displayReport() {
        System.out.println(" Student Report ");
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks1 + ", " + marks2 + ", " + marks3);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
    }
}

public class Studentgrademanagementsystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];

        // Input details
        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            System.out.println(" Student " + (i + 1) + "");
            students[i].inputDetails(sc);
            students[i].calculateGrade();
        }

        // Display reports
        System.out.println(" All Student Reports ");
        for (int i = 0; i < n; i++) {
            students[i].displayReport();
        }
    }
}