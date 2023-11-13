package lab4.Stack;

import lab4.models.IStack;

public class LinkedStack implements IStack {

    private class Node {
        int data;
        Node next;

        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    private Node top;


    @Override
    public void push(int element) {
        top = new Node(element, top);

    }

    @Override
    public int pop() {
        int element = top.data;
        top = top.next;

        return element;
    }

    @Override
    public int peek() {
        return top.data;
    }

    @Override
    public void clear() {
        Node temp = top.next;
        while (temp != null) {
            top  = null;
            top = temp;
            temp = top.next;
        }
        top = null;

    }

    @Override
    public void elements() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
    public boolean isFull() {
        return false;
    }

}
