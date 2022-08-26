package LeetcodeDailyProblems.August;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] count = new int[26];
        int mLength = magazine.length();
        int rLength = ransomNote.length();
        
        for(int i=0; i<mLength; i++) {
            int idx = magazine.charAt(i) - 'a';
            count[idx]++;
        }
        
        for(int i=0; i<rLength; i++) {
            int idx = ransomNote.charAt(i) - 'a';
            count[idx]--;
            if(count[idx] < 0)
                return false;
        }
        
        return true;
    }
}
