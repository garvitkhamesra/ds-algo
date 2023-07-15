package chapter3;

import java.util.EmptyStackException;

public class Stack<T> {
    private class StackNode<T> {
        T data;
        StackNode<T> next;

        StackNode(T data) {
            this.data = data;
        }
    }

    StackNode<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T val) {
        StackNode next = new StackNode(val);
        next.next = top;
        top = next;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        return data;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        System.out.println(stack.peek());
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(4);
        stack.push(57);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
