package EasyProblems;

public class StringPatternMatching {
    //Using KMP Algorithm
    public static int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();

        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int[] prefixArr = prefixArr(needle);
        int i=0, j=0;
        while(i < l1 && j < l2) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            }
            else {
                if(j > 0) {
                    j = prefixArr[j-1];
                }
                else
                    i++;
            }
        }
        return j == l2 ? i-j : -1;
    }

    public static int[] prefixArr(String needle) {
        int n = needle.length();
        int[] prefix = new int[n];
        int len = 0;
        int i = 1;
        while(i < n) {
            if(needle.charAt(i) == needle.charAt(len)) {
                len++;
                prefix[i] = len;
                i++;
            }
            else {
                if(len == 0) {
                    prefix[i] = 0;
                    i++;
                }
                else {
                    len = prefix[len-1];
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
