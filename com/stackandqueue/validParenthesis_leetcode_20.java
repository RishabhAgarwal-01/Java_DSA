package com.stackandqueue;
import java.util.Stack;
public class validParenthesis_leetcode_20 {

        public boolean isValid(String s) {
            Stack<Character> stack= new Stack<>();
            int length= s.length();
            for (char ch : s.toCharArray()) {
                if(ch=='{' || ch=='(' || ch=='['){
                    stack.push(ch);
                }
                else {
                    if(ch =='}'){
                        if( stack.isEmpty() || stack.pop() != '{'  ){
                            return false;
                        }
                    }
                    if(ch==')'){
                        if(stack.isEmpty() || stack.pop() != '(' ){
                            return false;
                        }
                    }
                    if(ch==']'){
                        if(stack.isEmpty() || stack.pop() != '[' ){
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }

}
