package Practice.DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> dict) {

        boolean[] f = new boolean[s.length() + 1];
        Set<String> wordDictSet = new HashSet<>(dict);
        f[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDictSet.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
