package EasyProblems;

import java.util.HashMap;
import java.util.Map;

public class Amazon1 {

    public static int minimumKeypadClickCount(String text) {
        int count = 0;
        int len = text.length();
        if(len <= 9) return len;
        Map<Character, Integer> click = new HashMap<>();
        for(int i=0; i<len; i++) {
            Character ch = text.charAt(i);
            if(click.containsKey(ch)) {
                count += click.get(ch);
            }
            else {
                int clickCount = 0;
                if(click.size() < 9)
                    clickCount = 1;
                else if(click.size()  < 18)
                    clickCount = 2;
                else if(click.size() < 26)
                    clickCount = 3;
                click.put(ch, clickCount);
                count += clickCount;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minimumKeypadClickCount("abcghdiefjoba"));
    }
}
