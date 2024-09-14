package com.Trees;

import java.util.ArrayList;
import java.util.List;

// Node structure for the binary tree
class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize
    // the node with a value
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
public class Boundary_element_traversal_leetcode_545 {
    //function to check if leaf npde or not
    boolean isLeaf(Node node){
        if(node.left != null && node.right != null){
            return true;
        }
        return false;
    }

    //Travel the left elements, also if some child is null then go to right
    void addLeftBoundary(Node node,List<Integer> res){
        Node currentNode = node.left;
        while (currentNode != null){
            if(!isLeaf(currentNode) ) res.add(currentNode.data);
            if(currentNode.left != null)
             currentNode= currentNode.left;
            else
                currentNode=currentNode.right;
        }
    }

    // Function to add the
    // leaves of the tree
    void addLeaves(Node root, List<Integer> res) {
        // If the current node is a
        // leaf, add its value to the result
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        // Recursively add leaves of
        // the left and right subtrees
        if (root.left != null) {
            addLeaves(root.left, res);
        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    //add the right boundary but in reverse so that proper anticlockwise is formed
    void addRightBoundary(Node node, List<Integer> res){
        Node currentNode = node.right;
        List<Integer> temp = new ArrayList<>();
        while(currentNode!=null){
            if(!isLeaf(currentNode)) temp.add(currentNode.data);

            if(currentNode.right != null)
                currentNode = currentNode.right;
            else
                currentNode = currentNode.left;
        }
        //reversing the list so that
        for (int i = temp.size() - 1; i >= 0; --i) {
            res.add(temp.get(i));
        }
    }

    // Main function to perform the
    // boundary traversal of the binary tree
    List<Integer> printBoundary(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // If the root is not a leaf,
        // add its value to the result
        if (!isLeaf(root)) {
            res.add(root.data);
        }

        // Add the left boundary, leaves,
        // and right boundary in order
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

}
