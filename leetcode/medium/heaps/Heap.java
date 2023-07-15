package heaps;

import java.util.Arrays;

public class Heap {

    int size = 0;
    int capacity = 10;
    int parentIndex;
    int leftChildIndex;
    int rightChildIndex;
    int heap[] = new int[capacity];

    public int getParentIndex(int index) {
        parentIndex = (index - 1) / 2;
        return  parentIndex;
    }
    public int getLeftChildIndex(int index) {
        leftChildIndex = (index * 2) + 1;
        return leftChildIndex;
    }
    public int getRightChildIndex(int index) {
        rightChildIndex = (index * 2) + 2;
        return rightChildIndex;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }
    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public int getParent(int index) {
        return heap[getParentIndex(index)];
    }
    public int getLeftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }
    public int getRightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    public void extendCapacity() {
        if (size == capacity) {
            capacity = 2 * capacity;
            heap = Arrays.copyOf(heap, capacity);
        }
    }

    public void swapNodes(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    public int peek() {
        if (size <= 0) throw new IllegalStateException("Size is less than equal to zero");
        return heap[0];
    }

    public int pollMinHeap() {
        if (size <= 0) throw new IllegalStateException("Size is less than equal to zero");
        int top = heap[0];
        heap[0] = heap[--size];
        minHeapifyDown();
        return top;
    }

    public void addElementInMinHeap(int value) {
        extendCapacity();
        heap[size++] = value;
        minHeapifyUp();
    }

    public void addElementInMaxHeap(int value) {
        extendCapacity();
        heap[size++] = value;
        maxHeapifyUp();
    }

    public int pollMaxHeap() {
        if (size <= 0) throw new IllegalStateException("Size is less than equal to zero");
        int top = heap[0];
        heap[0] = heap[--size];
        maxHeapifyDown();
        return top;
    }

    private void maxHeapifyUp() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) > getLeftChild(index)) {
                largerChildIndex = getRightChildIndex(index);
            }
            if (heap[index] > heap[largerChildIndex]) {
                break;
            } else {
                swapNodes(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }
    private void maxHeapifyDown() {
        int index = size - 1;
        int parentIndex = getParentIndex(index);
        while (hasParent(index) && heap[index] > getParent(index)) {
            swapNodes(index, parentIndex);
            index = parentIndex;
        }
    }

    private void minHeapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (heap[index] < heap[smallerChildIndex]) {
                break;
            } else {
                swapNodes(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
    private void minHeapifyUp() {
        int index = size - 1;
        int parentIndex = getParentIndex(index);
        while (hasParent(index) && heap[index] < getParent(index)) {
            swapNodes(index, parentIndex);
            index = parentIndex;
        }
    }

    public static void main(String[] args) {

    }
}
