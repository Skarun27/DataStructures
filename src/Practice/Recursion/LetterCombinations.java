package Practice.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                                       '6', "mno",'7', "pqrs", '8', "tuv", '9', "wxyz");
    
    public List<String> letterCombinations(String digits) {
        
        List<String> combinations = new ArrayList<>();
        if(digits.length() == 0) return combinations;
        backtracking(0, new StringBuilder(), combinations, digits);
        return combinations;
    }
    
    public List<String> backtracking(int index, 
                                     StringBuilder path, List<String> combinations, String digits) {
        
        if(path.length() == digits.length()) {
            combinations.add(path.toString());
            return combinations;
        }
        
        String letters = map.get(digits.charAt(index));
        for(char c: letters.toCharArray()) {
            path.append(c);
            backtracking(index+1, path, combinations, digits);
            path.deleteCharAt(path.length()-1);
        }
        return combinations;
    }
}
