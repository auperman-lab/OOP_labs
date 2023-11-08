package lab4.Queue;

import lab4.models.IQueue;

import java.util.Arrays;

public class ArrayUpQueue implements IQueue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public ArrayUpQueue() {
        queue = new int[5];
        size = 0;
        front = 0;
        rear = -1;
    }

    @Override
    public void enqueue(int element) {
        if (isFull()) {
            queue = Arrays.copyOf(queue, queue.length*2);
            front = 0;
            rear = size - 1;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            return 0;
        }
        int removedElement = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return removedElement;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            return 0;
        }
        return queue[front];
    }

    @Override
    public void clear() {
        queue = new int[queue.length];
        size = 0;
        front = 0;
        rear = -1;
    }

    @Override
    public void elements() {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    private boolean isFull() {

        return size == queue.length;
    }
}
