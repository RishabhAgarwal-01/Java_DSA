package com.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue_leetcode225 {
    private Queue<Integer> first;
    public StackUsingQueue_leetcode225() {
        first= new LinkedList<>();
    }

    public void push(int x) {
       first.add(x);
    }

    public int pop() {
       for(int i=0;i<first.size()-1;i++){
           first.add(first.remove());
       }
       int removed=  first.remove();

        return removed;
    }

    public int top() {
        for(int i=0;i<first.size()-1;i++){
            first.add(first.remove());
        }
        int top= first.peek();

        //now since the queue was rotated once the last element is now front for peek but peek never change the order of
        //element just return the top of the queue or stack so we have to add the first element to the back
        first.add(first.remove());

        return top;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
