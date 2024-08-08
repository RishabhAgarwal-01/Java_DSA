package com.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//THIS SOLUTION IS FOR AN ARRAY WITH UNIQUE ELEMENT

//can be solved using the backtracking paradigm where we either include a element or not include it and once we
//finish all the subsets with
public class subsets_leetcode_78 {
    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
     findSubsetBacktracking(nums,0,new ArrayList<>());
     return result;
    }

    public static void findSubsetBacktracking(int nums[], int index, List<Integer> sublist){
        //base case
        if(index == nums.length){
            result.add(new ArrayList<>(sublist));
            return;
        }

        //pick the element
        sublist.add(nums[index]);
        findSubsetBacktracking(nums, index+1, sublist);

        //while backtracking we remove the last added element if we have added a element to move to next stage in recursive call
        //removed the picked element
        sublist.remove(sublist.size()-1);
        //not picking the element
        findSubsetBacktracking(nums, index+1, sublist);
        //since not added any element we will not remove the element from this recursive call and nack track to the previous state
    }

    public static void main(String[] args) {
        int[] nums= {0};
        findSubsetBacktracking(nums,0,new ArrayList<Integer>());
        System.out.println(result);
    }

    //ANOTHER SOLUTION
    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findSubsetBacktrackingIterative(nums, 0, new ArrayList<>(), res);
        return result;
    }

    private void findSubsetBacktrackingIterative(int[] nums, int index, List<Integer> sublist, List<List<Integer>> res) {
        // Add the current subset to the result
        result.add(new ArrayList<>(sublist));

        // Iterate through the remaining elements
        for (int i = index; i < nums.length; i++) {
            // Include the current element
            sublist.add(nums[i]);

            // Recurse with the next index
            findSubsetBacktrackingIterative(nums, i + 1, sublist, res);

            // Backtrack by removing the current element
            sublist.remove(sublist.size() - 1);
        }
    }

}
