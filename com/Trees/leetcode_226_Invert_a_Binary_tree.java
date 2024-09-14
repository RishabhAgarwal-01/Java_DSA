package com.Trees;

class TreeNode {
      int val;
      Node left;
      Node right;

      TreeNode() {
      }

      TreeNode(int val) {
          this.val = val;
      }

      TreeNode(int val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class leetcode_226_Invert_a_Binary_tree {
    public Node invertTree(Node root) {
      if(root == null) return null;
      Node left = invertTree(root.left);
      Node right = invertTree(root.right);
      Node temp = left;
      root.left = right;
      root.right = temp;
      return root;
    }
}
