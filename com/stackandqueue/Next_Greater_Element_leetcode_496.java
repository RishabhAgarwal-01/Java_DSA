package com.stackandqueue;

import java.util.*;

public class Next_Greater_Element_leetcode_496 {
    //brute force approach
    public int[] nextGreaterElement_bruteForce(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length]; //all the values initially zero
        boolean found = false;
        for (int i = 0; i < nums1.length; i++) {
            found = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) { //found the element in nums2
                    found = true;
                }
                if (found && nums2[j] > nums1[i]) { //from there we will begin finding the next greater element in nums2
                    res[i] = nums2[j];
                    break;//corresponding to the nums1 element
                }
            }
            if (res[i] == 0) {
                res[i] = -1;
            }
        }
        return res;
    }
    //Optimal appproach for the good time complexity
    public int[] nextGreaterElement_Fast(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer>  map= new HashMap<Integer, Integer>();
        //Maintaing the index of each element in hashmap for nums2
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i], i);
        }
        //Now comparing the
        int[] res = new int[nums1.length];

        //Now comparing the each element but this time we don't need to traverse the whole nums2 array again to find the element in nums2
        for (int i = 0; i < nums1.length; i++) {
            for (int j = map.get(nums1[i]); j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) { //from there we will begin finding the next greater element in nums2
                    res[i] = nums2[j];
                    break;//corresponding to the nums1 element
                }
            }
            if (res[i] == 0) {
                res[i] = -1;
            }
        }
        return res;
    }

    //O(nums1.length+ nums2.length) approach
    //Optimal appproach for the good space complexity
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer>  map= new HashMap<Integer, Integer>();
        Stack <Integer> stack = new Stack<>();


        int[] res = new int[nums1.length];

        //Now comparing the each element but this time we don't need to traverse the whole nums2 array again to find the element in nums2
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i:stack){
            map.put(i, -1);
        }

        for(int i=0;i<res.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

}
