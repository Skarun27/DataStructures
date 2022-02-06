package SDESheet.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList();
        List<String> sublist = new ArrayList();
        findPalindrome(0, sublist, list, s);
        return list;
    }

    static void findPalindrome(int ind, List<String> sublist, List<List<String>> list, String s) {
        if(ind == s.length()) {
            list.add(new ArrayList<>(sublist));
            return;
        }

        for(int i=ind; i<s.length(); i++) {
            if(isPalindrome(s, ind, i)) {
                sublist.add(s.substring(ind, i+1));
                findPalindrome(i+1, sublist, list, s);
                sublist.remove(sublist.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int ind, int i) {
        while(ind <= i) {
            if(s.charAt(ind++) != s.charAt(i--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aabb"));
    }


}
