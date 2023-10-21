import java.util.Arrays;
import java.util.List;

public class Session {
    List<Student> students;

    public Session(List<Student> students) {
        this.students = students;
    }

    //Method to calculate average quiz scores of the students
    public double calculateAverageQuizScores(double[] quizScores) {
        double total = Arrays.stream(quizScores).sum();
        return Math.round(total / quizScores.length);
    }

    //Method to print average quiz scores of the students
    public void printStudentAverageQuizScore() {
        System.out.println("\nAverage scores of all students\n");
        for (Student student : students) {
            double averageScore = calculateAverageQuizScores(student.quizScores);
            Arrays.sort(student.quizScores);
            String studentType = (student instanceof FullTime) ? "Full-Time" : "Part-Time";
            System.out.println("\t" + student.studentName + " (Student ID: " + student.studentId + ") - " + studentType + " : " + averageScore);
        }
    }

    //Method to print quiz scores of the students in ascending order
    public void printQuizScoresInAscendingOrder() {
        System.out.println("\nQuiz scores of all students in ascending order\n");
        for (Student student : students) {
            Arrays.sort(student.quizScores);
            String studentType = (student instanceof FullTime) ? "Full-Time" : "Part-Time";
            System.out.println("\t" + student.studentName + " (Student ID: " + student.studentId + ") - " + studentType + " : " + Arrays.toString(student.quizScores));
        }
    }

    //Method to print names of part-time students
    public void printPartTimeStudentNames() {
        System.out.println("\nNames of Part-Time students\n");
        for (Student student : students) {
            if (student instanceof PartTime) {
                System.out.println("\t" + student.studentName + " (Student ID: " + student.studentId + ") - Part-Time");
            }
        }
    }

    //Method to print scores of full-time students
    public void printFullTimeStudentExamScores() {
        System.out.println("\nExam scores of Full-Time students\n");
        for (Student student : students) {
            if (student instanceof FullTime) {
                FullTime ftStudent = (FullTime) student;
                System.out.println("\t" + ftStudent.studentName + " (Student ID: " + ftStudent.studentId + ") : " + "Exam Score 1 : " + ftStudent.getExamScores()[0] + ", Exam Score 2 :" + ftStudent.getExamScores()[1]);
            }
        }
    }
}