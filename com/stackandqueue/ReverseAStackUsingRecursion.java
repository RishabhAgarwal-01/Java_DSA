package com.stackandqueue;

import java.util.Stack;

public class ReverseAStackUsingRecursion {
    static void insertAtbottom(Stack<Integer> st, int ele){
        //if empty simply push the passeed element which will be the bottom
        if(st.isEmpty()){
            st.push(ele);
        }
        //take out all the already present elements and till stack is empty and after the passed
        //ele is pushed to bottom again push all the element to top
        else {
            int temp= st.pop();
            insertAtbottom(st,ele);
            st.push(temp);
        }
    }

    //this whole function just traverse the stack till last element and keep on passing the correct
    //element to be inserted
    static void reverseStack(Stack<Integer> st){
          //if stack is empty just return
           if(st.isEmpty()){
            return;
           }
           //pop the top element
            int ele= st.pop();
           //recursively call to keep removing the top elements and storing it in the call stack
            reverseStack(st);
            //call the insert function to insert the element at bottom of the stack by actally
        //taking each of them out aone by one and placing the passed element at bottom then placing the
        //remaining items
            insertAtbottom(st, ele);

    }

    public static void main(String[] args) {
        Stack<Integer> st= new Stack<>();
        st.push(5);
        st.push(3);
        st.push(2);
        st.push(1);
        System.out.println(st.peek());
        System.out.println(st.toString());
        reverseStack(st);
        System.out.println(st.peek());
        System.out.println(st.toString());

    }
}
