package medium.stack.queue;


import java.util.ArrayList;
import java.util.Stack;

public class StackOfPlates {
    ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    int capacity = 2;
    public void push(int value) {
        Stack<Integer> stack = getLastStack();
        if (stack.size() == capacity) {
            Stack<Integer> stack1 = new Stack();
            stack1.add(value);
            stacks.add(stack1);
        } else {
            stack.add(value);
            stacks.add(stack);
        }
    }

    private Stack<Integer> getLastStack() {
        if (stacks.size() == 0) return new Stack<>();
        return stacks.get(stacks.size() - 1);
    }

    public int pop() {
        Stack<Integer> stack = getLastStack();
        int value = stack.pop();
        if (stack.size() == 0) stacks.remove(stacks.size() - 1);
        return value;
    }

    public static void main(String[] args) {
        StackOfPlates stack = new StackOfPlates();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
