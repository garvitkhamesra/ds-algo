package chapter3;

public class SortStack {
    public void sort(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!tempStack.isEmpty() && temp < tempStack.peek()) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        while (!tempStack.isEmpty()) stack.push(tempStack.pop());
    }

    public static void sortWithRecursion(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortWithRecursion(stack);
            insert(stack, temp);
        }
    }

    private static void insert(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() > value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insert(stack, value);
            stack.push(temp);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(57);
        System.out.println(stack.peek());

        SortStack sortStack = new SortStack();
        //sortStack.sort(stack);
        sortStack.sortWithRecursion(stack);
        System.out.println(stack.peek());
    }
}
