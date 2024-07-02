package com.stackandqueue;

public class CircularQueueMain {
    public static void main(String[] args) throws Exception{
        CircularQueue cq= new CircularQueue(5);
        cq.insert(1);
        cq.insert(2);
        cq.insert(3);
        cq.insert(4);
        cq.insert(5);

        cq.display();

        System.out.println(cq.remove());
        cq.display();
//        System.out.println(cq.front());
    }
}
