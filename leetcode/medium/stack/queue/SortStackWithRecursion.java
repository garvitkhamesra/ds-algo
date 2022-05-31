package medium.stack.queue;

import java.util.Arrays;
import java.util.Stack;

public class SortStackWithRecursion {
    static Stack<Integer> stack;

    public static void sort() {
        if (!stack.isEmpty()) {
            System.out.println("Sort " + stack+" Stack Size: " + stack.size());
            int temp = stack.pop();
            sort();
            insert(temp);
        }
    }

    private static void insert(int value) {
        System.out.println("Insert " + stack+" Stack Size: " + stack.size());
        if (stack.isEmpty() || stack.peek() < value) {
            System.out.println("Inserting Value: " + value);
            stack.push(value);
        } else {
            int temp = stack.pop();
            insert(value);
            System.out.println("Inserting Value: " + temp);
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
