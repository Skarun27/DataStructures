package SDESheet.ArraysPartII;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumber {
    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> list = new ArrayList();
        for(int i=0; i<A.size(); i++) {
            if(A.get(i)-1 == -1)
                list.add(i);
            else
                A.set(A.get(i), -1);
        }
        for(int i=0; i<A.size(); i++) {
            if(A.get(i) != -1)
                list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        System.out.println(repeatedNumber(list));
    }
}
