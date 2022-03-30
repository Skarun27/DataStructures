import java.util.HashMap;

public class test {

    public static int[] solution(String[] arr) {
        int[] res = new int[3];
        int j=0;
        while(j < arr[0].length()) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0; i<arr.length; i++) {
                if(map.containsKey(arr[i].charAt(j))) {
                    res[0] = map.get(arr[i].charAt(j));
                    res[1] = i;
                    res[2] = j;
                    break;
                }
                else {
                    map.put(arr[i].charAt(j), i);
                }
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"bbafg", "ceagi"};
        int[] res = solution(arr);
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    
}
