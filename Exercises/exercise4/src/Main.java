import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Regular expressions and their names
        String[] regexPatterns = {
                // country code +1 followed by mobile number in xxx-xxx-xxxx format
                "^\\+1-(\\d{3})-(\\d{3})-(\\d{4})$",

                // 24 hour time format
                "([01]?[0-9]|2[0-3]):[0-5][0-9]",

                // gmail address with letters (a-z), numbers (0-9), and periods (.). No special characters or more
                // than one period (.) in a row.
                "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*@gmail\\.com$",

                //Valid Username containing only letters, digits, underscores, periods, and hyphens,
                // with a length between 4 and 20 characters
                "^[a-zA-Z0-9_\\-\\.]{4,20}$",


                //password with at least 1 uppercase, 1 lowercase, 1 digit, 1 special character, and
                // a total length between 8 and 16 characters
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[\\W_]).{8,16}$"
        };

        //Pattern Strings to match
        String[] patternString = {
                "US Mobile Number with Country Code",
                "24-Hour Time Format (HH:MM)",
                "Match gmail account",
                "Valid Username",
                "Strong password"
        };

        // Example subjects for each regular expression
        String[][] subjects = {
                {
                        "+1-346-857-4658", "+4-673-869-7765", "+1-8890-645-154",
                },
                {
                        "25:30", "13:05", "09:45"
                },
                {
                        "harrypotter31@gmail.com", "lily.Potter10@gmail.com", "TomRiddle@12@ymail.com"
                },
                {
                        "Hermoine@Ministry", "Dobby.Is.Free2", "Expecto-Patronum"
                },
                {
                        "Qt3@57thUi", "rgy76b$#3434bghYY", "dzhgb*fjdg"
                }
        };

        for (int i = 0; i < regexPatterns.length; i++) {
            System.out.println("Pattern String: " + patternString[i]);
            System.out.println("Regular Expression: " + regexPatterns[i]);
            Pattern pattern = Pattern.compile(regexPatterns[i]);

            for (String subject : subjects[i]) {
                Matcher matcher = pattern.matcher(subject);
                boolean isMatch = matcher.matches();
                String result = isMatch ? "Positive" : "Negative";
                System.out.println("\tInput: " + subject + "\n\tResult: " + result);
            }

            System.out.println();
        }
    }
}



