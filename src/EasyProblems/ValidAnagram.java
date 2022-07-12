// package EasyProblems;

// public class ValidAnagram {
//     public static boolean isAnagram(String s, String t) {
//         int s1 = s.length();
//         if(s1 != t.length()) return false;
//         int[] arr = new int[26];

//         for(int i=0; i<s1; i++) {
//             arr[s.charAt(i) - 'a'] += 1;
//         }

//         for(int i=0; i<s1; i++) {
//             if(arr[t.charAt(i) - 'a'] == 0)
//                 return false;
//             else
//                 arr[t.charAt(i) - 'a'] -= 1;
//         }

//         return true;
//     }

//     public static void main(String[] args) {
//         String s = "anagram", t = "nagaram";
//         System.out.println(isAnagram(s, t));
//     }
// }
