package com.Trees;

public class leetcode_124_max_path_sum_of_BT {
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
    int ans = Integer.MIN_VALUE;
      //the solution include traversing the left and right of each node, then giving back the path sum till that
    //node so that we can calculate sum of path that is formed by the said node and update the ans if it is
    //greater than the current ans. Also when we are moving to the top parent node after calculating the current node
    //path sum then make the choice which left or right path from that node is greater that should be considered
    //for it to be included in the parent node path.
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
    private int helper(TreeNode node){
        if(node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        //ignore the paths that are returning the negative values becuase it will reduce the ans
        left = Math.max(0, left);
        right = Math.max(0,right);

        int currentNodePathSum = left+right+node.val;

        ans = Math.max(ans, currentNodePathSum);

        return Math.max(left, right) +node.val;
    }
}
