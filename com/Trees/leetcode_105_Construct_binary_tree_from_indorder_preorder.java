package com.Trees;

import com.sun.source.tree.Tree;

import java.util.HashMap;

public class leetcode_105_Construct_binary_tree_from_indorder_preorder {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          //store the index for each node in inorder array
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int [] index = {0};
        return helper(preorder, inorder, 0, preorder.length-1, map, index);
    }

    public TreeNode helper(int [] preorder, int [] inorder, int left, int right, HashMap<Integer, Integer> map, int [] index){

          if(left>right) {
              return null;
          }
          int current = preorder[index[0]];
          index[0]++;

          TreeNode node = new TreeNode(current);

          //if the index value for the left and right in inorder become same then it means we are at leaf node and we
        //will not traverse any further
          if(left == right) return node;

          //get the current inorderIndex and split the inorder array for left and right again and again for each recursive calls
          int inorderIndex = map.get(current);
          //left of the current node
          node.left = helper(preorder, inorder, left, inorderIndex-1, map, index);
          //right of the current node
          node.right =  helper(preorder, inorder, inorderIndex+1, right, map, index);

          return node;
    }
}
