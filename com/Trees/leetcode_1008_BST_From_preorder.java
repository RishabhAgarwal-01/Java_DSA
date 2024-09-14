package com.Trees;

public class leetcode_1008_BST_From_preorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private int index =0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode bstHelper(int [] preorder, int lowerBound, int upperBound){
        if(index == preorder.length || preorder[index] <lowerBound || preorder[index] > upperBound ){
            return null;
        }
        int val = preorder[index];
        index++;
        TreeNode node = new TreeNode(val);
        node.left = bstHelper(preorder, lowerBound, node.val);
        node.right = bstHelper(preorder, node.val, upperBound);
        return node;
    }
}
