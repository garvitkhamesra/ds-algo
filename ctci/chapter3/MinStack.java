package chapter3;

public class MinStack extends Stack<Integer>{
    Stack<Integer> minStack;

    MinStack() {
        minStack = new Stack<>();
    }

    @Override
    public Integer pop() {
        int val = super.pop();
        if (val == min()) minStack.pop();
        return val;
    }

    @Override
    public void push(Integer val) {
        if (minStack.isEmpty() || min() >= val) {
            minStack.push(val);
        }
        super.push(val);
    }

    public int min() {
        if (minStack.isEmpty()) return Integer.MAX_VALUE;
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.min());
        stack.push(-1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
