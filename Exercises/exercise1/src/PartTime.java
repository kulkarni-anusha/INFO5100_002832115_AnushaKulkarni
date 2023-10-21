//Derived class Part Time
public class PartTime extends Student {
    //PartTime class constructor
    public PartTime(double[] quizScores, String studentName, int studentId) {
        //accessing parent class using super keyword
        super(quizScores, studentName, studentId);
    }
}