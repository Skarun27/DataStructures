package SDESheet.StackAndQueueII;

import java.util.Stack;

public class OnlineStockSpan {
    Stack<int[]> stack;

    public OnlineStockSpan() {
        stack = new Stack();
    }

    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }

    public static void main(String[] args) {

    }
}
