package SDESheet.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderPostorderInorderInSingleTraversal {
    static class Pair {
        Node node;
        int num;
        Pair(Node _node, int _num) {
            num = _num;
            node = _node;
        }
    }

    public static List<List<Integer>> getTreeTraversal(Node root) {
        // Write your code here.
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        if (root == null) return list;

        while (!st.isEmpty()) {
            Pair it = st.pop();

            // this is part of pre
            // increment 1 to 2
            // push the left side of the tree
            if (it.num == 1) {
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }

            // this is a part of in
            // increment 2 to 3
            // push right
            else if (it.num == 2) {
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            // don't push it back again
            else {
                post.add(it.node.data);
            }
        }

        list.add(in);
        list.add(post);
        list.add(pre);
        return list;
    }

    private class Node {
        int data;
        Node left;
        Node right;
        Node() {}
        Node(int val) {
            this.data = val;
        }
    }
}
