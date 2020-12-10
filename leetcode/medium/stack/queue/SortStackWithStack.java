package stack.queue;

import java.util.Stack;

public class SortStackWithStack {
    public Stack<Integer> sort(Stack<Integer> s)
    {
        Stack<Integer> tempStack = new Stack<>();
        while (!s.isEmpty()) {
            int top = s.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > top) {
                s.push(tempStack.pop());
            }
            tempStack.push(top);
        }
        return tempStack;
    }
}
