package SDESheet.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PathToGivenNode {
    Stack<Integer> st = new Stack();

    public ArrayList<Integer> solve(TreeNode A, int B) {

        ArrayList<Integer> list = new ArrayList();
        recursive(A, B);
        while(!st.isEmpty()) {
            list.add(st.pop());
        }
        return list;
    }

    public boolean recursive(TreeNode A, int B) {

        if(A == null)
            return false;
        if(A.val == B) {
            st.push(A.val);
            return true;
        }
        if(recursive(A.left, B) || recursive(A.right, B)) {
            st.push(A.val);
            return true;
        }
        return false;
    }

    // Definition for a binary tree node.
      private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int val) { this.val = val; }
     }
}
