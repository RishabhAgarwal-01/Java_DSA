package com.Trees;

import java.util.*;

public class leetcode_863_All_Nodes_Distance_K_in_Binary_Tree {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  public void findParents(TreeNode root, HashMap<TreeNode, TreeNode> track_parent){
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()){
          TreeNode currentNode = queue.poll();
          if(currentNode.left != null){
              track_parent.put(currentNode.left, currentNode);
              queue.offer(currentNode.left);
          }
          if(currentNode.right != null){
              track_parent.put(currentNode.right, currentNode);
              queue.offer(currentNode.right);
          }
      }
  }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> track_parent = new HashMap<>();
        findParents(root, track_parent);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int curr_level =0;
        visited.put(target, true);
        queue.offer(target);
        while (!queue.isEmpty()){
            int size = queue.size();
            if(curr_level == k) break;
            curr_level ++;
            for (int i=0;i<size;i++){
                TreeNode current = queue.poll();
                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(track_parent.get(current) != null && visited.get(track_parent.get(current)) == null){
                    queue.offer(track_parent.get(current));
                    visited.put(track_parent.get(current), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }
}
