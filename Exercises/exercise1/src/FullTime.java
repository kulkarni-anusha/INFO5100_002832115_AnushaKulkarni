//Derived class Full Time
public class FullTime extends Student {
    double[] examScores = new double[2]; //Array to store 2 exam scores

    //FullTime class constructor
    public FullTime(double[] quizScores, String studentName, int studentId, double[] examScores) {
        //accessing parent class using super keyword
        super(quizScores, studentName, studentId);
        this.examScores = examScores;
    }

    public double[] getExamScores() {
        return examScores;
    }
}