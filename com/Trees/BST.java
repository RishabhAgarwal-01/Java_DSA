package com.Trees;

import java.util.*;

public class BST {
    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;


        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    private Node root;

    public BST(){
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    //
    public void insert(int value){
      root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value<node.value){
            node.left=insert(value, node.left);
        }
        if(value>node.value){
            node.right=insert(value, node.right);
        }
        node.height = node.height+1;
        return node;
    }

    public void display(Node node, String details){
        if(node ==null){
            return;
        }
        System.out.println(details + node.getValue());
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }


    //preorder traversal  --- Node -> Left --> Right
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.value+ " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //Inoder Traversal --- Left-->Node-->Right
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value+ " ");
        inOrder(node.right);
    }

    //PostOrder --- Left-->right-->Node
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value+ " ");
    }

    //LevelOrder Traversal
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return ans;
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if(currentNode.left != null)
                    queue.add(currentNode.left);
                if(currentNode.right != null)
                    queue.add(currentNode.right);
            }
            ans.add(currentLevel);
        }
        return ans;
    }
    //iterative approach for the preorder traversal Node-->left--right but since here we will use the stack ds then we have to store
    //the right first so that left is on the top and extracted before right as Stack is LIFO ds


}
