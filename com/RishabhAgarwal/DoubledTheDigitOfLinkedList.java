package com.RishabhAgarwal;
//This is the approch where we use the recursion to solve the leetcode 2816
public class DoubledTheDigitOfLinkedList extends LinkedListRecursion{
    int car; //global carry variable

    public void doubleUtil(Node head) {
        if (head == null) return;

        doubleUtil(head.next);

        int cur = 2 * head.val + car;
        car = cur / 10;

        head.val = cur % 10;
    }

    public Node doubleIt(Node head) {
        car = 0;
        doubleUtil(head);

        return (car == 0) ? head : new Node(car, head);
    }
}
