package com.RishabhAgarwal;

import java.util.HashMap;

//leetcode 138 create deep copy with the random nodes pointer
//Here we will use the memoization concept with the hash map, and then store the nodes of old list acting as the key for
//new deep copied nodes. Then we will again move the pointers and get values from the hash map and keep on making changes
//We can not use the traditional copy approach because random nodes are not made yet for each iteration.
public class CreateDeepCopyWithRandomNodes_leetcode138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            HashMap<Node, Node> memory = new HashMap<>();
            Node temp = head;
            //storing key value pair i.e. if node(7) - node(7)
            while (temp != null) {
                memory.put(temp, new Node(temp.val));
                temp = temp.next;
            }

            temp = head;

            while (temp != null) {
                Node copyNode = memory.get(temp);
                copyNode.next = memory.get(temp.next); //
                copyNode.random = memory.get(temp.random);
                temp = temp.next;
            }
            return memory.get(head);
        }
    }

}
