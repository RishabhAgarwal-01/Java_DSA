package com.Trees;

public class leetcode_230_kth_smallest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Default constructor
        TreeNode() {}

        // Constructor with value
        TreeNode(int val) {
            this.val = val;
        }

        // Constructor with value, left child, and right child
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private int count = 0;  // Track the number of nodes visited
    private int result = -1;  // Store the kth smallest element

    // Function to find the kth smallest element in the BST
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);  // Perform in-order traversal to find the element
        return result;  // Return the found element
    }

    // Helper function to perform in-order traversal
    private void inOrderTraversal(TreeNode root, int k) {
        // Base case: return if the node is null
        if (root == null) return;

        // Traverse the left subtree
        inOrderTraversal(root.left, k);

        // Increment the counter when visiting this node
        count++;

        // Check if the current node is the kth smallest
        if (count == k) {
            result = root.val;
            return;  // Stop further traversal once the result is found
        }

        // Traverse the right subtree
        inOrderTraversal(root.right, k);
    }
}
