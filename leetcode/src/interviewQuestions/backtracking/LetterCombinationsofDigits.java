package interviewQuestions.backtracking;

import java.util.*;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/793/
public class LetterCombinationsofDigits {
    static Map<Character, String> hmap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static List<String> lecom(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        combs(result, digits, "", 0);
        return result;
    }

    static void combs(List<String> result, String digits, String currentCombination, int index) {
        if (index == digits.length()) {
            result.add(currentCombination);
            return;
        }
        String letters = hmap.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            combs(result, digits, currentCombination + letters.charAt(i), index + 1);
        }
    }

    public static void main(String[] args) {
        String m = new String();
        Scanner scanner = new Scanner(System.in);
        m = scanner.next();

        List<String> result = lecom(m);
        System.out.println(result);
        scanner.close();
    }


}
