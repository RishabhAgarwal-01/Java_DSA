package com.RishabhAgarwal;
//leetcode 143 Reorder list
/* we will find the mid of the list, then from there reverse the list. Maintain the two three pointers, headFirst,
* headSecond and temp. headFirst points to the first element of the list, headSecond points to the last element of the list
* or we can say the first element of the reversed part of the list, temp is going to help in changing the right value for other pointers
* by pointing to the next values of pointers from the list previous to the ongoing changes */
public class ReorderListLeetcode143 extends LinkedListRecursion{
    public Node findingMid(Node head){
        Node slow=head;
        Node fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node reverseListFromMid(Node mid){
        Node prevNode = null;
        Node currentNode = mid;
        Node nextNode = currentNode.next;
        while(currentNode != null){
            currentNode.next= prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
             if(nextNode != null){
                 nextNode = nextNode.next;
             }
        }
        return prevNode;
    }
    public void reorderList(Node head) {
        //finding the mid
        Node mid = findingMid(head);
        // finding reverse
        Node headSecond = reverseListFromMid(mid);
        Node headFirst = head;

        Node temp = null;
        while(headFirst != null && headSecond != null){
            temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;
            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond= temp;
        }
        //checking if headFirst has became the null or not yet because it may happen that headSecond become null first and
        //it create a loop within the last element where last element of the new list will keep on pointing to itself and
        //loop will end as headSecond == null.
        //At this time headFirst will be pointing to the ending element, so we will make headFirst.next = null and end the program
        if(headFirst != null){
            headFirst.next = null;
        }
    }
}
