package com.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_199_Binary_Tree_Right_Side_view extends BinaryTree{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode currentNode = queue.poll();
                if (i==levelSize-1){
                    ans.add(currentNode.value);
                }
                if(currentNode.left != null)
                    queue.add(currentNode.left);
                if(currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }
        return ans;
    }
}
