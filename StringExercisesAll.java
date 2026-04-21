package LAB3B;

public class StringExercisesA{

    // Q1: Check if string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }

    // Q2: Count occurrences of substring
    public static int countOccurrences(String main, String sub) {
        int count = 0, index = 0;
        while ((index = main.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    // Q3: Reverse string
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Q4: Palindrome check (ignore case & punctuation)
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    // Q5: Remove whitespace
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        System.out.println("=== String Exercises ===");

        // Q1 Demo
        String test1 = null;
        String test2 = "   ";
        String test3 = "Hello";
        System.out.println("\nQ1: Null or Empty Check");
        System.out.println("Test1: " + isNullOrEmpty(test1)); // true
        System.out.println("Test2: " + isNullOrEmpty(test2)); // true
        System.out.println("Test3: " + isNullOrEmpty(test3)); // false

        // Q2 Demo
        String main = "banana bandana banana";
        String sub = "ana";
        System.out.println("\nQ2: Count Occurrences");
        System.out.println("Occurrences of '" + sub + "' in '" + main + "': " + countOccurrences(main, sub));

        // Q3 Demo
        String input = "Hello World";
        System.out.println("\nQ3: Reverse String");
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reverseString(input));

        // Q4 Demo
        String testPalindrome1 = "Madam, I'm Adam";
        String testPalindrome2 = "Hello";
        System.out.println("\nQ4: Palindrome Check");
        System.out.println("'" + testPalindrome1 + "' is palindrome? " + isPalindrome(testPalindrome1));
        System.out.println("'" + testPalindrome2 + "' is palindrome? " + isPalindrome(testPalindrome2));

        // Q5 Demo
        String inputWhitespace = "Java   Programming   Language";
        System.out.println("\nQ5: Remove Whitespace");
        System.out.println("Original: " + inputWhitespace);
        System.out.println("Without Whitespace: " + removeWhitespace(inputWhitespace));
    }
}
