package InterviewQuestions;
import java.util.*;

public class AmazonFullTime1 {
    public static long maximumQuality(List<Integer> packets, int channels){
        long res = 0;
        Collections.sort(packets);
        int n = packets.size();
        for (int i = n-1;i>n-channels;i--) {
            res += packets.get(i);
        }
        // 0~n-channels
        int len = n-channels+1;
        // odd
        if ((len&1)==1) {
            res += packets.get(len / 2);
        } else {
            res += (packets.get(len/2) + packets.get(len/2-1)+1)/2;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
//        list.add(48);
//        list.add(14);
//        list.add();
//        list.add();
        System.out.println(maximumQuality(list, 1));

    }
}
