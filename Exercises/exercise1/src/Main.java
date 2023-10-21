import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Names for full-time students
        String[] fullTimeNames = {
                "Monica", "Chandler", "Joey", "Ross", "Rachel",
                "Phoebe", "Ted", "Marshall", "Barney", "Robin"
        };

        // Names for part-time students
        String[] partTimeNames = {
                "Fred", "Ginny", "Harry", "Ron", "Hermione",
                "Albus", "Tom", "Severus", "Lily", "James"
        };

        // Populate 20 students with dummy scores and add them to the list
        for (int i = 1; i <= 20; i++) {
            if (i <= 10) {
                FullTime fullTime = new FullTime(getQuizScores(), fullTimeNames[i - 1], i, new double[]{getExamScores()[0], getExamScores()[1]});
                students.add(fullTime);
            } else {
                PartTime partTime = new PartTime(getQuizScores(), partTimeNames[i - 11], i);
                students.add(partTime);
            }
        }

        Session session = new Session(students);

        // Call all public methods of class Session to capture output
        session.printStudentAverageQuizScore();
        session.printQuizScoresInAscendingOrder();
        session.printPartTimeStudentNames();
        session.printFullTimeStudentExamScores();
    }

    // Method to generate 15 random quiz scores for each student
    public static double[] getQuizScores() {
        double[] quizScores = new double[15];
        for (int i = 0; i < 15; i++) {
            double min = 0.0;
            double max = 100.0;
            double range = max - min;
            quizScores[i] = Math.round((Math.random() * range) + min);
        }
        return quizScores;
    }

    // Method to generate 2 random exam scores for each student
    public static double[] getExamScores() {
        double[] examScores = new double[2];
        double min = 0.0;
        double max = 100.0;
        double range = max - min;
        for (int i = 0; i < 2; i++) {
            examScores[i] = Math.round((Math.random() * range) + min);
        }
        return examScores;
    }
}