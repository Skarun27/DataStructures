package InterviewQuestions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombOfPhoneNumber {

    private static List<String> combinations = new ArrayList<>();
    private static String inputDigits;
    private static Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno",'7', "pqrs", '8', "tuv", '9', "wxyz");

    public static List<String> letterCombinations(String digits) {

        inputDigits = digits;
        if(inputDigits.length() == 0) return combinations;
        backtracking(0, new StringBuilder());
        return combinations;
    }

    public static void backtracking(int index, StringBuilder path) {

        if(path.length() == inputDigits.length()) {
            combinations.add(path.toString());
            return;
        }

        String letters = map.get(inputDigits.charAt(index));
        for(char c: letters.toCharArray()) {
            path.append(c);
            backtracking(index+1, path);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
