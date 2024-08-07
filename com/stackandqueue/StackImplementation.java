package com.stackandqueue;

public class StackImplementation {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr =-1;

    public StackImplementation(){
        this(DEFAULT_SIZE); //constructor chaining in case no size is given
    }
    public StackImplementation(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return  ptr == data.length-1; //ptr is at last index
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return false;
    }

    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException("can not pop from an empty stack");
        }

        return data[ptr--];
    }

    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("can not pop from an empty stack");
        }
        return data[ptr];
    }

}
