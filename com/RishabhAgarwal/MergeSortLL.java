package com.RishabhAgarwal;


public class MergeSortLL {
    private ListNode head;
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid= getMidNode(head); //getting the mid
        ListNode left = sortList(head); //calling the sortList for list before mid
        ListNode right= sortList(mid); //after mid recursion

        return MergeSort(left, right); //when reached the single element then calling MergeSort

    }



    //Merge sort operation is based on the clasic Merge sort.
    public ListNode MergeSort(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode(); //This is dummy head and store the null value
        //we will return the dummyHead.next as the head of the new list
        ListNode temp = dummyHead;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next= list1;
                list1 = list1.next;
                temp = temp.next; //this increases the temp pointer to the next node from dummyHead
            }
            else {
                temp.next= list2;
                list2 = list2.next;
                temp = temp.next;
            }

        }
        temp.next = (list1 != null)? list1 :list2;
        return dummyHead.next;
    }

    //finding the middle
    public ListNode getMidNode(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        while( fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return  slow;
    }
}
