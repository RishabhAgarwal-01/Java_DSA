package com.Recursion;

import java.util.*;

public class CombinationSum2_leetcode_40 {
    //FIRST METHOD SAME AS COMBINATION SUM 1 but TLE otherwise correct O(2^n * klogn)
        private static void findAllCombinations(int index, int[] candidates, int target,
                                                Set<List<Integer>> hashset , List<Integer> sublist){
            //if index equals the candidate length then return but if target becomes 0 then add the sublist to the ans list
            if(index == candidates.length){
                if(target==0){
                    // Sort the sublist before adding to set
                    List<Integer> sortedSublist = new ArrayList<>(sublist);
                    sortedSublist.sort(null); // Sort in natural order
                    hashset.add(sortedSublist);
                }
                return;
            }

            //if at any point the index value become less than target and target do not increase
            if(candidates[index] <= target){
                //NOTE : we will keep on picking the same index value until the base conditions are not hit
                //pick condition
                sublist.add(candidates[index]);
                findAllCombinations(index+1, candidates, target-candidates[index], hashset, sublist);

                //remove the picked element if picked for the backtracking calls
                sublist.remove(sublist.size()-1);
            }
            //not pick condition
            findAllCombinations(index+1, candidates, target, hashset, sublist);
        }

        public List<List<Integer>> combinationSum2FirstApproach(int[] candidates, int target) {
            Set<List<Integer>> hashset = new HashSet<>();
            List<List<Integer>> ans = new ArrayList<>();
            findAllCombinations(0, candidates, target, hashset, new ArrayList<>());

            // Convert Set to List
            ans.addAll(hashset);
            return ans;
        }

        //BETTER SOLUTION
        public static void helper(int index, int[] candidates, int target,
                                  List<List<Integer>> result, List<Integer> sublist, int sum) {
            if (sum == target) {
                result.add(new ArrayList<>(sublist));
                return;
            }
            if (sum > target || index >= candidates.length) {
                return;
            }

            // Pick the element, increase the sum, and explore
            sublist.add(candidates[index]);
            helper(index + 1, candidates, target, result, sublist, sum + candidates[index]);

            // Don't pick the element and explore
            // Remove the element for backtracking
            sublist.remove(sublist.size() - 1);

            // Skip duplicates
            while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
                index++;
            }
            helper(index + 1, candidates, target, result, sublist, sum);
        }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

}
