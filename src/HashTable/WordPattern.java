package HashTable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {

        Map map = new HashMap();
        String[] words = s.split(" ");

        if(words.length != pattern.length())
            return false;

        for(Integer i=0; i<words.length; i++) {
            char pat = pattern.charAt(i);
            String word = words[i];

            if(!map.containsKey(pat)) {
                map.put(pat, i);
            }

            if(!map.containsKey(word)) {
                map.put(word, i);
            }

            if(map.get(word) != map.get(pat))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String pattern = "abba";
        System.out.println(wordPattern(pattern, s));
    }
}
