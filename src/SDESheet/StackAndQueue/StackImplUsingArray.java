package SDESheet.StackAndQueue;

public class StackImplUsingArray {
    static class stack {
        int size = 10000;
        int arr[] = new int[size];
        int top = -1;
        void push(int x) {
            top++;
            arr[top] = x;
        }
        int pop() {
            int x = arr[top];
            top--;
            return x;
        }
        int top() {
            return arr[top];
        }
        int size() {
            return top + 1;
        }
    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println(s.top());
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.top());
    }
}
