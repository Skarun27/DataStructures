package SDESheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StackAndQueueII {
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList();
        Stack<Integer> stack = new Stack();
        for(int i=0; i<A.size(); i++) {
            if(!stack.isEmpty() && stack.peek() < A.get(i)) {
                res.add(stack.peek());
                stack.push(A.get(i));
            }
            else {
                while(!stack.isEmpty() && stack.peek() >= A.get(i)) {
                    stack.pop();
                }
                if(!stack.isEmpty()) res.add(stack.peek());
                else res.add(-1);
                stack.push(A.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(4,5,2,10,8));
        ArrayList<Integer> arr2 = prevSmaller(arr1);
        for(Integer i: arr2)
            System.out.println(i);
    }
}
