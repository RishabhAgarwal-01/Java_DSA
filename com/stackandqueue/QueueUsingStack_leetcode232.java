package com.stackandqueue;

import java.util.Stack;

public class QueueUsingStack_leetcode232 {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public QueueUsingStack_leetcode232() {
        first= new Stack<>();
        second= new Stack<>();
    }

    public void push(int x) {
         first.push(x);
    }

    public int pop()throws Exception{
        if(first.isEmpty()){
            throw new Exception("Queue is empty");
        }
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int removed = second.pop();

        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return removed;
    }

    public int peek() throws Exception {
        if(first.isEmpty()){
            throw new Exception("Queue is empty");
        }
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int firstElement = second.peek();

        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return firstElement;
    }

    public boolean empty() {
       return first.isEmpty();
    }
}
