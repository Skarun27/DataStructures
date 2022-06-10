package LeetcodeDailyProblems.JuneMonth;

import java.util.HashMap;

public class LongestSubWoRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int count = 0;
        if(s.length() == 1) return 1;
        
        for(int i=0; i<s.length(); i++) {
            
            if(map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i))+1, start);
            }
            count = Math.max(count, i - start + 1);
            map.put(s.charAt(i), i);
        }
            
        return count;
    }
}
