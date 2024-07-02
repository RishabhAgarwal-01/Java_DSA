package com.RishabhAgarwal;

//leetcode 2 medium
public class AddTwoNumbers extends LinkedListRecursion {
    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(); //dummy head for a new list that will be returned
        Node currentNode = dummyHead; //sort of temp node to make changes
        int carry = 0;
        Node l1Head = l1;
        Node l2Head = l2;
        while (l1Head != null && l2Head != null) {
            int v = (l1Head.val + l2Head.val + carry);
            carry = v / 10;
            currentNode.next = new Node(v%10);
            currentNode = currentNode.next;
            l1Head = l1Head.next;
            l2Head = l2Head.next;
        }
        if (l1Head == null) {
            while (l2Head != null) {
                int v = (l2Head.val + carry) ;
                carry = v / 10;
                currentNode.next = new Node(v%10);
                currentNode = currentNode.next;
                l2Head = l2Head.next;
            }
        }
        if (l2Head == null) {
            while (l1Head != null) {
                int v = (l1Head.val + carry) ;
                carry = v / 10;
                currentNode.next = new Node(v%10);
                currentNode = currentNode.next;
                l1Head = l1Head.next;
            }
        }
        if (carry > 0) {
            currentNode.next = new Node(carry);
        }
        return dummyHead.next;
    }
}

