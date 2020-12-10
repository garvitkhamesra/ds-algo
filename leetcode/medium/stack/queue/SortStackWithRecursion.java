package stack.queue;

import java.util.Stack;

public class SortStackWithRecursion {
    static Stack<Integer> stack;

    public static void sort() {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort();
            insert(temp);
        }
    }

    private static void insert(int value) {
        if (stack.isEmpty() || stack.peek() < value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insert(value);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        stack = new Stack<>();
        stack.add(12112);
        stack.add(21);
        stack.add(300);
        stack.add(41);
        stack.add(52);

        for (int i : stack) {
            System.out.print(i + " ,");
        }
        System.out.println("\n>>>");
        sort();
        System.out.println("<<<");
        for (int i : stack) {
            System.out.print(i + " ,");
        }
    }
}
