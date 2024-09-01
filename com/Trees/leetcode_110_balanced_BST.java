package com.Trees;

public class leetcode_110_balanced_BST extends leetcode_104_Max_depth_of_BinaryTree {

    public int height(Node root){
        if(root==null)
            return 0;
        int leftHeight = height(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = height(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight-rightHeight) >1) return -1;

        return Math.max(leftHeight,rightHeight)+1;

    }
    public boolean isBalanced(Node root) {
        int ans = height(root);
        return ans !=-1;
    }
}
