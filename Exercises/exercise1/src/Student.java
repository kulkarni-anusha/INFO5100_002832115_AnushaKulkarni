//Parent class Student
public class Student {
    public double[] quizScores;
    String studentName;
    int studentId;

    //student class constructor
    public Student(double[] quizScores, String studentName, int studentId) {
        this.studentName = studentName;
        this.quizScores = quizScores;
        this.studentId = studentId;
    }
}
