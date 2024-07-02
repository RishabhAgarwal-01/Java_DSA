package com.RishabhAgarwal;

import java.util.ArrayList;
import java.util.List;

public class LinkedListRecursion {
    private Node head;

    class Node {
        int val;
        Node next;

        public Node() {

        }
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public void insertRec(int val, int index) {
        if (head == null) {
            Node newNode = new Node(val);
            head = newNode;
            newNode.next = null;
        } else {
            head = insertRec(val, index, head);
        }

    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node newNode = new Node(val);
            newNode.next = node.next;
            node.next = newNode;
            return node;
        }
        node.next = insertRec(val, index--, node.next);
        return node;
    }

    public void printLinkedList() {
        Node currNode = head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.val + "->");

            // Go to next node
            currNode = currNode.next;
        }

    }

    //simple method to remove the duplicates
    public void removeDuplicate(Node head) {
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next != null && currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    //cycle detection using the f and s pointer approach
    //for every cycle, f pointer will move the 2 nodes while the s pointer will move one node,
    //eventually the f and s pointer gonna meet if one of them doesn't reach the null first
    //return true or false as such
    public boolean cycleDetectionLL(Node head) {
        Node f = head;
        Node s = head;
        while (f != null || f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                return true;
            }

        }
        return false;
    }


    //now we can be asked to calucalte the length of the cycle if it is present then what we have to do is just calculate
// do the same steps till the cycle is detected and after that have to use just cal the length by storing the s pointer
//in the temp pointer and keep on incraesing the temp till it again reaches to the s pointer and increase the counter
    public int lengthOfCycle(Node head) {
        Node f = head;
        Node s = head;
        while (f != null || f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                Node temp = s;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != s);
                return length;
            }

        }
        return 0;
    }

    //Now next question is if we will be asked to return the node from where the cycle has started then we will use a little
//modified version of f-s pointer method.
//The idea is to put my second pointer at such position in the cycle that if the node where the cycle start should be at
//K th node from the first pointer and also the Kth node from the second pointer and when the both pointer will move ONE
//STEP AT A TIME then they will meet at that point only.To calculate where to place the second pointer, calculate the
//length of cycle, move the s pointer that time and then start moving the both pointer at same time unti both meet
    public Node findStartNodeOfCycle(Node head) {
        int length = 0;
        Node f = head;
        Node s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                length = lengthOfCycle(head);
            }
        }
            if (length == 0) return null;

            while (length > 0) {
                s = s.next;
                length--;
            }
            while (f != s) {
                f = f.next;
                s = s.next;
            }
          return f;
    }

    //Now the question is ---> Find the middle of the linked list
    //In this question we can do it in 2 ways
    //1st calculate the length of the linked list and then traverse the half
    //2nd approach is that what if we have to do it in the one pass only
    //use the fast and slow approach, if fast pointer runs 2 times nodes then by the time it reaches the end the slow
    //pointer will be at the half end only
    public Node middleNode(Node head) {
        Node slow= head;
        Node fast= head;
        while( fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return  slow;
    }

    //Now the question is about the iterative or in place reversal of the linked list where we maintain three
    //pointers Prev, Current and Next and just visualise it and code
    public Node reverseList(Node head){
        Node prevNode = null;
        Node currentNode = head;
        Node nextNode = currentNode.next;

        while(currentNode != null){
            currentNode.next = prevNode;
            prevNode= currentNode;
            currentNode = nextNode;
            if(nextNode != null) //null pointer check
            nextNode = nextNode.next;
        }
        head = prevNode;
        return head;
    }

    /*  Double a Number Represented as a Linked List
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
Return the head of the linked list after doubling it.
Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189.
Hence, the returned linked list represents the number 189 * 2 = 378.*/

    //we will use the reverselist method defined above
    public Node doubleIt(Node head){
        head = reverseList(head);
        Node dummyHead = head;
        Node prevNode= null;
        int carry=0;
        while(dummyHead != null){
            int currValue = dummyHead.val * 2 + carry;
            dummyHead.val = currValue%10;
            carry = currValue / 10;
            prevNode = dummyHead;
            dummyHead= dummyHead.next;
        }
        if(carry != 0){
            prevNode.next = new Node(carry);
        }

        head = reverseList(head); //again has to reverse the list because the direction of pointer is still
        //same pointing in reverse
        //earlier it was head->1->2->3->4
        //after reversing it became 1<-2<-3<-4<-head
        //even if we change the head to last pointer the direction will remain same and when reading from the head it will
        //read only the first digit after solution
        return head;
    }

    //leetcode 234
    //Palindrome linkedlist

    //1st approach using recursion
    Node temp;
    public boolean traverseLast(Node head){

        if(head == null)
            return true;

        boolean isPal = traverseLast(head.next);
        if (!isPal) {
            return false;
        }

        if(temp.val != head.val)
            return false;
        temp = temp.next;

        return true;
    }
    public boolean isPalindrome(Node head) {
        temp = head;
        boolean check = traverseLast(head);
        if(check == true)
            return true;
        else
            return false;
    }
    //better approach to solve using the internal java implementation of list storing the each value in the list in one pass
    //also make sure to move the
    //calculating it's length and then simply traversing in loop comparing the list<Integer> from the start and end
    //start ++ and end --
    class Solution {
        public boolean isPalindrome(Node head) {
            List<Integer> list = new ArrayList();
            while(head != null) {
                list.add(head.val);
                head = head.next;
            }

            int left = 0;
            int right = list.size()-1;
            while(left < right && list.get(left) == list.get(right)) {
                left++;
                right--;
                if(left >= right)
                    return false;
            }
            return true;
        }
    }


}




