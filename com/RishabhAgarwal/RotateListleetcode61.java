package com.RishabhAgarwal;
//leetcode 62 Rotate the list by k terms.
public class RotateListleetcode61 extends LinkedListRecursion{
    //calculate the length and place the tail at last
    public Node rotateRight(Node head, int k) {
        //calculate the length and place a tail at the last node
        if(head == null || head.next == null){
            return head;
        }
        Node tail= head;
        Node temp = head;
        int size =0;
        while(tail.next != null){
            size++;
            tail = tail.next;
        }
        tail.next = head;

        k = k%size; //This gives exact rotation need to be performed even if the number of roations are greater than size
        int skipNodes = size-k;
        for(int i = 1; temp !=null && i<skipNodes; i++){
            temp = temp.next;
        }
        head= temp.next;
        tail = temp;
        tail.next = null;
        return head;
    }
}
