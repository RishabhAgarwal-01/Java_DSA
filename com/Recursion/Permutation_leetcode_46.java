package com.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation_leetcode_46 {

    private static void permuteHelper(int[] nums, List<List<Integer>> ans,
                                     List<Integer> sublist, boolean[] freq) {
        if(sublist.size() == nums.length){
            ans.add(new ArrayList<>(sublist));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]= true;
                sublist.add(nums[i]);
                permuteHelper(nums, ans, sublist, freq);
                //REMEMBER this caused me confusion everytime
                //the reason for removing the element in no pick is that we are passing the current instance of
                //the sublist and freq map to the next recursion call or received it from some other previous
                //recursion call. Any changes made to that instance will also be reflected in the previous call's
                //data structure instance. So we remove it before backtracking so that the changes become nullified for the
                //next iteration
                sublist.remove(sublist.size()-1);
                freq[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
       boolean[] freq= new boolean[nums.length];
       permuteHelper(nums,ans,new ArrayList<>(),freq);
       return ans;
    }
}
