package lab4.Stack;

import lab4.models.IStack;

import java.util.Arrays;

public class ArrayUpStack implements IStack{
    private int[] stack;
    private int top;

    public ArrayUpStack(){
        stack = new int[5];
        top = 0;
    }
    @Override
    public void push(int element){
        if(top == stack.length){
            stack = Arrays.copyOf(stack, top*2);
        }
        stack[top] = element;
        top++;
    }

    @Override
    public int pop() {

        int element = stack[top];
        stack[top] = 0;
        top--;
        return element;
    }

    @Override
    public int peek() {
        return stack[top];
    }

    @Override
    public void clear() {
        stack = new int[5];
        top = 0;
    }

    @Override
    public void elements() {
        for(int i:stack){
            System.out.println(i + " ");
        }

    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

}
