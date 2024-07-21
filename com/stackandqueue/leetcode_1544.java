package com.stackandqueue;

import java.util.Stack;

public class leetcode_1544 {
        public String makeGood(String s) {
            Stack<Character> st= new Stack<>();
            int len= s.length();

            for(int i=0;i<len;i++){
                char curr =s.charAt(i);
                // Check if stack is not empty and top element and current character are the same letter with different cases
                if (!st.isEmpty() && Math.abs(st.peek() - curr) == 32) {
                    st.pop();
                } else {
                    st.push(curr);
                }
            }
            System.out.println(st.toString());
            String str="";
            System.out.println(st.size());
            while(!st.isEmpty()){
                str= st.pop()+str;
                System.out.println(str);
            }
            return str;
        }

    public String makeGoodsecond(String s) {
        StringBuilder res = new StringBuilder();

        int i = 0;

        while (i < s.length()) {
            int m = res.length();
            if (m > 0 && Math.abs(res.charAt(m - 1) - s.charAt(i)) == 32) {
                res.deleteCharAt(m - 1);
                i++;
            } else {
                res.append(s.charAt(i));
                i++;
            }
        }

        return res.toString();
        }

    public static void main(String[] args) {
           leetcode_1544 obj= new leetcode_1544();
        String str= "leEeetcode";
        System.out.println(obj.makeGoodsecond(str));
    }
}
