package com.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_leetcode_39 {
    private static void findAllCombinations(int index, int[] candidates, int target,
            List<List<Integer>> ans ,List<Integer> sublist){
        //if index equals the candidate length then return but if target becomes 0 then add the sublist to the ans list
        if(index == candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(sublist));
            }
            return;
        }

        //if at any point the index value become less than target and target do not increase
        if(candidates[index] < target){
            //NOTE : we will keep on picking the same index value until the base conditions are not hit
            //pick condition
            sublist.add(candidates[index]);
            findAllCombinations(index, candidates, target-candidates[index], ans, sublist);

            //remove the picked element if picked for the backtracking calls
            sublist.remove(sublist.size()-1);
        }
        //not pick condition
        findAllCombinations(index+1, candidates, target, ans, sublist);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<>();
        findAllCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
