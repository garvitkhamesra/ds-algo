import java.util.Arrays;

public class Stack<T> {
    private T[] stack;
    private int top;

    Stack(int size) {
        this.stack = (T[]) new Object[size];
        this.top = -1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void push(T data) {
        this.stack[++top] = data;
    }

    public T pop() {
        /*An object can't be garbage collected as long as it is reachable. If you simply change your index with --N,
        but do not nullify a[N], you will keep a reference to that object, preventing its garbage collection even if
        the client code does not reference that object any longer.
        An object that exists beyond its intended lifetime is, by definition, a loitering object. */
        T data = this.stack[top];
        this.stack[top--] = null;
        return data;
    }

    public void printStack() {
        System.out.println(Arrays.toString(stack));
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.push(3);
        stack.push(3);
        stack.printStack();
    }
}

/*When the array is full double the size of array, but when the array is quater full the half the array.*/
