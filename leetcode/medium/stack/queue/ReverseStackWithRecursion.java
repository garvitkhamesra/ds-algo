package stack.queue;

import java.util.Stack;

public class ReverseStackWithRecursion {
    static Stack<Integer> stack;

    public static void reverse() {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverse();
            insert(temp);
        }
    }

    private static void insert(int value) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            insert(value);
            stack.push(temp);
        } else {
            stack.push(value);
        }
    }

    public static void main(String[] args) {
        stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        for (int i : stack) {
            System.out.print(i + " ,");
        }
        System.out.println("\n>>>");
        reverse();
        System.out.println("<<<");
        for (int i : stack) {
            System.out.print(i + " ,");
        }
    }
}
