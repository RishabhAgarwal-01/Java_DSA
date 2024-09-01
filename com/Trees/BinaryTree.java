package com.Trees;

import java.util.*;

class BinaryTree {
    public BinaryTree(){

    }
   protected static class TreeNode{
       int value;
       TreeNode left;
       TreeNode right;

       public TreeNode(int value){
           this.value=value;
       }
   }
   private TreeNode root;

    //insert elements
    public void populate(Scanner scanner){
        System.out.println("Enter the root TreeNode value");
        int value= scanner.nextInt();
        root = new TreeNode(value);
        populate(scanner,root);
    }
    public void populate(Scanner scanner, TreeNode TreeNode){
        System.out.println("Do you want to enter left of"+ TreeNode.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the left of "+ TreeNode.value);
            int value= scanner.nextInt();
            TreeNode.left = new TreeNode(value);
            populate(scanner, TreeNode.left);
        }

        System.out.println("Do you want to enter right of"+ TreeNode.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the right of "+ TreeNode.value);
            int value= scanner.nextInt();
            TreeNode.right = new TreeNode(value);
            populate(scanner, TreeNode.right);
        }
    }

    public void display(){
        display(root,"");
    }
    private void display(TreeNode TreeNode, String indent){
        if(TreeNode == null){
            return;
        }
        System.out.println(indent+TreeNode.value);
        display(TreeNode.left, indent+"\t");
        display(TreeNode.right ,indent+"\t");
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
    }

    //diameter of the binary tree -The diameter of a binary tree is the length of the
    // longest path between any two TreeNodes in a tree. This path may or may
    // not pass through the root. The length of a path between two TreeNodes is represented
    // by the number of edges between them.
    public int find_max(TreeNode root, int max) {
        if(root == null) return 0;
        int left_subtree_height = find_max(root.left, max);
        int right_subtree_height = find_max(root.right, max);
        max = Math.max(max, left_subtree_height+right_subtree_height);
        return 1+ Math.max(left_subtree_height, right_subtree_height);
    }
    public int diameterOfBinaryTree(TreeNode root){
        int diameter = find_max(root, 0);
        return diameter;
    }

    //zigzag traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        if(root == null) return ans;
        dq.add(root);
        boolean reverse = false;
        while(!dq.isEmpty()){
            int levelSize = dq.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                if(!reverse) {
                    TreeNode currentNode = dq.pollFirst();
                    currentLevel.add(currentNode.value);
                    if(currentNode.left != null)
                        dq.addLast(currentNode.left);
                    if(currentNode.right != null)
                        dq.addLast(currentNode.right);
                }else {
                    TreeNode currentNode = dq.pollLast();
                    currentLevel.add(currentNode.value);
                    if(currentNode.left != null)
                        dq.addFirst(currentNode.left);
                    if(currentNode.right != null)
                        dq.addFirst(currentNode.right);

                }
            }
            ans.add(currentLevel);
            reverse = !reverse;
    }
        return ans;
    }
}
