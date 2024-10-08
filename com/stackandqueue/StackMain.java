package com.stackandqueue;

public class StackMain {
    public static void main(String[] args)throws StackException {
//        StackImplementation stack= new StackImplementation(5);
//
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//
////        System.out.println(stack.pop()); to check the exception

        DynamicStack stack= new DynamicStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(10);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

       System.out.println(stack.pop()); //to check the exception
    }
}
