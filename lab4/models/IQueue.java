package lab4.models;

public interface IQueue {
    void enqueue(int element);
    int dequeue();
    int peek();
    void clear();
    void elements();
    boolean isEmpty();
}
