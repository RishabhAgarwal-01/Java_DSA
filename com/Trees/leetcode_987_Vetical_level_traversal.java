package com.Trees;

import java.util.*;

public class leetcode_987_Vetical_level_traversal {
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

        //this pair will store the values of queue that will contain both the col (-1,0,1) and the
        //actual reference to the node to extract the data and left and right node from it
        static class Tupple {
            int row;
            int col;
            TreeNode node;

            public Tupple(int row, int col, TreeNode node) {
                this.row = row;
                this.col = col;
                this.node = node;
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            // List to store all the nodes with their respective row and column information
            List<Tupple> nodeList = new ArrayList<>();

            // BFS traversal to add nodes to the list with row and col information
            Queue<Tupple> queue = new ArrayDeque<>();
            queue.add(new Tupple(0, 0, root));

            while (!queue.isEmpty()) {
                Tupple curr = queue.poll();
                nodeList.add(curr);  // Store current node

                if (curr.node.left != null) {
                    queue.add(new Tupple(curr.row + 1, curr.col - 1, curr.node.left));
                }
                if (curr.node.right != null) {
                    queue.add(new Tupple(curr.row + 1, curr.col + 1, curr.node.right));
                }
            }

            // Sort by column first, then row, then node value
            Collections.sort(nodeList, (a, b) -> {
                if (a.col != b.col) return a.col - b.col;    // Sort by column
                if (a.row != b.row) return a.row - b.row;    // Sort by row
                return a.node.val - b.node.val;              // Sort by node value if same row and col
            });

            // Use a map to group nodes by column
            Map<Integer, List<Integer>> colMap = new TreeMap<>();
            for (Tupple tupple : nodeList) {
                colMap.putIfAbsent(tupple.col, new ArrayList<>());
                colMap.get(tupple.col).add(tupple.node.val);
            }

            // Collect the result
            List<List<Integer>> result = new ArrayList<>();
            for (List<Integer> colValues : colMap.values()) {
                result.add(colValues);
            }

            return result;
        }
    }
}
