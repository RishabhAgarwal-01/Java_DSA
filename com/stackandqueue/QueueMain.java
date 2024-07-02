package com.stackandqueue;

public class QueueMain {
    public static void main(String[] args) throws Exception{
        QueueImplementation queue = new QueueImplementation(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        queue.display();

        System.out.println(queue.remove());
        System.out.println(queue.front());
    }
}
