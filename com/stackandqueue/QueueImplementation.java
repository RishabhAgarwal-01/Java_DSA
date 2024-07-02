package com.stackandqueue;

import java.util.Queue;

public class QueueImplementation {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end =0;

    public QueueImplementation(){
        this(DEFAULT_SIZE); //constructor chaining in case no size is given
    }
    public QueueImplementation(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return  end == data.length; //ptr is at last index
    }


    public boolean isEmpty(){
        return end == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++]= item;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed = data[0];

        //shifting the element towards left
        for(int i=1;i<end;i++){
            data[i-1]= data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }

    public void display(){
        for(int i=0;i< end;i++){
            System.out.print(data[i]+ "<-");
        }
        System.out.println(("End"));
    }

}
