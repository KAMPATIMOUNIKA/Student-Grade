import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("👩‍🎓 Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int s = 1; s <= numStudents; s++) {
            System.out.println("\n🧑‍🎓 Student " + s + ":");

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter number of subjects for " + name + ": ");
            int numSubjects = scanner.nextInt();

            int[] marks = new int[numSubjects];
            int totalMarks = 0;

            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                marks[i] = scanner.nextInt();

                while (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("❌ Invalid input! Marks must be between 0 and 100.");
                    System.out.print("Re-enter marks for subject " + (i + 1) + ": ");
                    marks[i] = scanner.nextInt();
                }

                totalMarks += marks[i];
            }

            double average = (double) totalMarks / numSubjects;

            String grade;
            if (average >= 90) {
                grade = "A+";
            } else if (average >= 80) {
                grade = "A";
            } else if (average >= 70) {
                grade = "B";
            } else if (average >= 60) {
                grade = "C";
            } else if (average >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Display result
            System.out.println("\n📋 --- Report Card for " + name + " ---");
            System.out.println("✅ Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
            System.out.printf("📊 Average Percentage: %.2f%%\n", average);
            System.out.println("🏅 Grade: " + grade);

            scanner.nextLine(); // consume newline for next student
        }

        scanner.close();
    }
}
