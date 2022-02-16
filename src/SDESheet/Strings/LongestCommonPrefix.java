package SDESheet.Strings;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<strs.length; i++) {
            if(min > strs[i].length())
                min = strs[i].length();
        }

        for(int i=0; i<min; i++) {
            char letter = strs[0].charAt(i);
            for(int j=0; j<strs.length; j++) {
                if(strs[j].charAt(i) != letter)
                    return prefix.toString();
            }
            prefix.append(letter);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] str = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
    }
}
