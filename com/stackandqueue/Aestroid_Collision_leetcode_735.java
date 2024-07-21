package com.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Aestroid_Collision_leetcode_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st= new Stack<>();
        int n= asteroids.length;
        //traverse through each aestroid
        for(int i=0;i<n;i++){
            //if aestroid is positive push in stack
            //keep in mind that if first asteroid is -ve then if will just go to right and if a +ve asteroid come after it
            //then it will just go ahead without colliding with it
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }
            //if negative then check
            else {
                //if top of stack is +ve and asteroid is -ve and bigger than top keep popping
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                }
                //handle the case when both the +ve and -ve then remove both, simply means pop hte top and don't include the
                //-ve in stack
                if (!st.isEmpty() && st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                }
                //if it is empty or top of stack has -ve element then add the negative element
                else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
                // Else, the current asteroid will be destroyed, do nothing
            }
        }
        // Convert stack to int[]
        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }
}
