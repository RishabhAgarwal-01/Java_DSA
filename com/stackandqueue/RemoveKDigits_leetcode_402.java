package com.stackandqueue;

import java.util.Stack;

public class RemoveKDigits_leetcode_402 {
    public String removeKdigits(String num, int k) {

        int count=k;
        Stack<Character> st= new Stack<>();
        char charr[] = num.toCharArray();
        for(char ch: charr){
            while(!st.isEmpty() && count>0 && (st.peek()-'0')>(ch-'0')){
                st.pop();
                count--;
            }
            st.push(ch);
        }
        //if count remains then just remove the top k elements from stack this also handles the condition like 123456
        //where there will be no removals intially just push operations in above loop
        while(count>0){
            st.pop();
            count--;
        }
        //if stack get empty after k removals that means k= string.length
        if(st.isEmpty()){
            return "0";
        }
        // Build the result string from the stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        // Reverse the result as we built it from the end to the beginning
        sb.reverse();

        // Remove leading zeros manually
        int startIndex = 0;
        while (startIndex < sb.length() && sb.charAt(startIndex) == '0') {
            startIndex++;
        }

        // If all digits are zeros, return "0"
        if (startIndex == sb.length()) {
            return "0";
        }

        // Otherwise, return the string from the first non-zero digit
        return sb.substring(startIndex);
    }
}
