package com.Trees;

public class leetcode_104_Max_depth_of_BinaryTree {
    public class Node{
        public int value;
        public Node left;
        public Node right;
//        private int height;


        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    private Node root;

    //it can be solved by calulating the left and right sub tree height and returning the max
    //at each node we traverse
    public int maxDepth(Node root) {
        if(root == null)
            return 0;

        int leftTreeHeight = maxDepth(root.left);
        int rightTreeHeight = maxDepth(root.right);

        return 1+Math.max(leftTreeHeight, rightTreeHeight);
    }
}
