package com.Trees;

public class leetcode_98_validate_binary_search_tree {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean isValidBST(TreeNode root) {
        return helper(root, null , null);
    }
    //taking Integer wrapper class instead of int because the int can not store the null while
    //wrapper classes can as they create a instance or object
    private boolean helper(TreeNode current, Integer low, Integer high){
         if(current == null) return true;
         //check the range in which a node must be for it to be at valid position in valid bst
         if(low != null && current.val <= low){
             return false;
         }
         if(high != null && current.val >= high){
             return false;
         }
         //in leftnode can have the same low value as it's parent
         boolean leftTree = helper(current.left, low, current.val);
         boolean rightTree = helper(current.right, current.val, high);

         return leftTree && rightTree;
    }
}
