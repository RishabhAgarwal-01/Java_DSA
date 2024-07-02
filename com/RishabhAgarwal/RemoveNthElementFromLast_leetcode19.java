package com.RishabhAgarwal;
//leetcode 19 Remove Nth Element From Last
public class RemoveNthElementFromLast_leetcode19 extends LinkedListRecursion {
    public Node removeNthFromEnd(Node head, int n) {
        if(head == null || head.next == null){
            head = null;
            return head;
        }
        Node tail = head;
        int size =1;
        while(tail.next != null){
            size ++;
            tail = tail.next;
        }
        if(n>size){
            return head;
        }

        Node temp = head;
        Node prevNode = temp;
        n=n%size;
        int skippedNodes = size -n;
        for(int i=1;temp !=  null && i<skippedNodes;i++){
            prevNode = temp;
            temp= temp.next;
        }
        prevNode.next = temp.next;
        temp.next = null;
        return head;
    }
}
