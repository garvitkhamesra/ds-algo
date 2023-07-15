package chapter3;

public class QueueViaStack<T> {
    Stack<T> stack, stack2;

    QueueViaStack() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public void add(T val) {
        stack.push(val);
    }

    public T remove() {
        shiftStacks();
        return stack2.pop();
    }

    public T peek() {
        shiftStacks();
        return stack2.peek();
    }

    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueViaStack queue = new QueueViaStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
    }
}
