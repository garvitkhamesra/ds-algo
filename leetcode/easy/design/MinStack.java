package easy.design;

/**
 * User: garvit
 * Date: 04/01/20 4:32 PM
 */
public class MinStack {
    private int[] stack;
    private int size;
    private int min;
    private int top;
    public MinStack() {
        stack = new int[2];
        size = 2;
        min = Integer.MAX_VALUE;
        top = -1;
    }

    public void push(int x) {
        increaseSize();
        if (min > x) min = x;
        stack[++top] = x;
    }

    public void pop() {
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return min;
    }

    private void increaseSize() {
        if (top >= size/2) {
            int[] temp = new int[size*2];
            size *= 2;
            for (int i = 0; i < top; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
