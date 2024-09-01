package com.Trees;

public class leetcode_116_populating_next_right_pointers_in_each_node {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if(root==null) return null;
        Node leftMostNode = root;
        while(leftMostNode.left != null){
            Node currentNode = leftMostNode;
            //travesing the level and connecting each node children in that level
            while(currentNode != null){
                currentNode.left.next = currentNode.right;
                //to connect the right and left node of two subtrees
                if(currentNode.next != null){
                    currentNode.right.next = currentNode.next.left;
                }
                currentNode= currentNode.next;
            }
            leftMostNode=leftMostNode.left;
        }
        return root;
    }
}
