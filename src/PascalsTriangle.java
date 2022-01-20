import java.util.ArrayList;
import java.util.List;

class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        if(numRows == 1) {
            list.add(list1);
            return list;
        }
        list.add(list1);
        list.add(list2);
        for(int i=2; i<numRows; i++) {
            List<Integer> currList = new ArrayList<>();
            List<Integer> prevList = list.get(i-1);
            currList.add(1);
            int j = 1;
            while(j < prevList.size()) {
                int currVal = prevList.get(j-1) + prevList.get(j);
                currList.add(currVal);
                j++;
            }
            currList.add(1);
            list.add(currList);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = generate(2);
        System.out.println(list);
    }
}