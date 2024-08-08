package com.Recursion;

import java.util.ArrayList;
import java.util.List;

public class subsetI_leetcode_78 {

        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            findSubsetBacktracking(nums,0,new ArrayList<>(), result);
            return result;
        }

        public static void findSubsetBacktracking(int nums[], int index, List<Integer> sublist, List<List<Integer>> result){

            //base case
            if(index == nums.length ){
                result.add(new ArrayList<>(sublist));
                return;
            }

            //pick the element and explore
            sublist.add(nums[index]);
            findSubsetBacktracking(nums, index+1, sublist, result);

            //don't pick the element and explore
            sublist.remove(sublist.size()-1);
            findSubsetBacktracking(nums, index+1, sublist, result);

        }

        public static void main(String[] args) {
            int[] nums= {1,2,2};
            List<List<Integer>> result;
            result = subsets(nums);
            System.out.println(result);
        }
}


