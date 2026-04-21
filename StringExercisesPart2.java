package LAB3C;

import java.util.Random;

public class StringExercisesPart2 {

    // Q6: Capitalize first letter of each word
    public static String capitalizeWords(String str) {
        String[] words = str.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (w.length() > 0) {
                sb.append(Character.toUpperCase(w.charAt(0)))
                  .append(w.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Q7: Truncate string with ellipsis
    public static String truncate(String str, int length) {
        if (str == null || str.length() <= length) {
            return str;
        }
        return str.substring(0, length) + "...";
    }

    // Q8: Check if string is numeric
    public static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    // Q9: Generate random string of specified length
    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // Q10: Count words in a string
    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) return 0;
        return str.trim().split("\\s+").length;
    }

    public static void main(String[] args) {
        System.out.println("=== String Exercises Part 2 ===");

        // Q6 Demo
        String sentence = "java programming language is powerful";
        System.out.println("\nQ6: Capitalize Words");
        System.out.println("Original: " + sentence);
        System.out.println("Capitalized: " + capitalizeWords(sentence));

        // Q7 Demo
        String longText = "This is a long sentence that needs truncation.";
        System.out.println("\nQ7: Truncate String");
        System.out.println("Original: " + longText);
        System.out.println("Truncated (15 chars): " + truncate(longText, 15));

        // Q8 Demo
        String numTest1 = "12345";
        String numTest2 = "12a45";
        System.out.println("\nQ8: Numeric Check");
        System.out.println(numTest1 + " is numeric? " + isNumeric(numTest1));
        System.out.println(numTest2 + " is numeric? " + isNumeric(numTest2));

        // Q9 Demo
        System.out.println("\nQ9: Generate Random String");
        System.out.println("Random String (length 8): " + generateRandomString(8));

        // Q10 Demo
        String text = "Java is fun to learn";
        System.out.println("\nQ10: Count Words");
        System.out.println("Text: " + text);
        System.out.println("Word Count: " + countWords(text));
    }
}
