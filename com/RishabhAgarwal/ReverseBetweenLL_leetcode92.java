package com.RishabhAgarwal;
//leetcode 92
public class ReverseBetweenLL_leetcode92 extends LinkedListRecursion{

    public Node reverseBetween(Node head, int left, int right) {
        if (left == right) {
            return head;
        }
        Node currentNode = head;
        Node prevNode = null;

        for(int i=0; currentNode != null && i< left-1; i++){
            prevNode= currentNode;
            currentNode = currentNode.next;
        }
        Node leftNode = prevNode;
        Node newEnd = currentNode;

        Node nextNode = currentNode.next;

        for(int i=0; currentNode != null && i< right-left; i++) {
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        if(leftNode != null){
            leftNode.next = prevNode;
        }
        else {
            head = prevNode;
        }
        newEnd.next = currentNode;
        return head;
    }
}
