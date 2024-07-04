package com.stackandqueue;

import java.util.Stack;

//this class will store the pair values of the current push and the minimum of the stack
class Pair{
  int val, min;
  Pair(int val, int min){
      this.val= val;
      this.min= min;
  }
}

public class MinStackImplementation_leetcode155 {
    Stack<Pair> stack;
    public MinStackImplementation_leetcode155() {
     stack= new Stack<>();
    }

    public void push(int val) {
        int min;
        if(stack.isEmpty()) {
            min = val;
        }
        else{
            min= Math.min(stack.peek().min, val);
        }
        stack.push(new Pair(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
