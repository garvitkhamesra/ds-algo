import java.util.Arrays;

public class Queue<T> {
    private T[] queue;
    private int first, last;

    Queue(int size) {
        this.queue = (T[]) new Object[size];
        this.first = -1;
        this.last = -1;
    }

    private boolean isEmpty() {
        return first == -1;
    }

    public void enqueue(T data) {
        this.queue[++first] = data;
    }

    public void dequeue() {
        /*An object can't be garbage collected as long as it is reachable. If you simply change your index with --N,
        but do not nullify a[N], you will keep a reference to that object, preventing its garbage collection even if
        the client code does not reference that object any longer.
        An object that exists beyond its intended lifetime is, by definition, a loitering object. */
        this.queue[++last] = null;
    }

    public void printQueue() {
        System.out.println("First Pointer -> " + first);
        System.out.println(Arrays.toString(queue));
        System.out.println("Last Pointer -> " + last);
    }

    public static void main(String[] args) {
        Queue queue = new Queue(15);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }
}