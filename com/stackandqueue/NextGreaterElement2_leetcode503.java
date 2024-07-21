package com.stackandqueue;

import java.util.Stack;

public class NextGreaterElement2_leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len= nums.length;
        int res[] = new int[len];

        //we are trying to immitate the copying of the array
        for(int i=2*len-1;i>=0;i++){
            while(! stack.isEmpty() && stack.peek()<=nums[i%len]){
                stack.pop();
            }
            if(i<len){
                if (!stack.isEmpty()) {
                    res[i] = stack.peek();
                }
                else {
                    res[i] =-1;
                }
                stack.push(nums[i%len]);
            }
        }
        return res;
    }
}
