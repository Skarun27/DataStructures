package SDESheet.StackAndQueueII;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<=heights.length; i++) {
            while(!st.isEmpty() && (i==heights.length || heights[st.peek()] >= heights[i])) {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()) width = i;
                else width = i - st.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            st.push(i);
        }
        return maxArea;
    }
}
