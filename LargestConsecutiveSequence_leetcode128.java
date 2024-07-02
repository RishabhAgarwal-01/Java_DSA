import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestConsecutiveSequence_leetcode128 {
    //sorting approach
    public int longestConsecutiveSortingApproach(int[] nums) {
        int n = nums.length;
        //edge case if nums.length =0
        if (n == 0)
            return 0;

        //sort the given array in O(NlogN) complexity
        Arrays.sort(nums);

        //loop to get the largest sequence
        int prevSmallestElement = Integer.MIN_VALUE; //gives us the previous element
        int currentSequence = 1;
        int largestSequence = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == prevSmallestElement) { //if nums[i] == prevSmallestElement then it must be included in the current
                //sequence count
                currentSequence++;
                prevSmallestElement = nums[i]; //change the prevSmallest for next number
            } else if (nums[i] == prevSmallestElement) {
                continue;
            } else if (nums[i] - 1 != prevSmallestElement) { //if not then start the new sequence altogether from 0
                currentSequence = 1; //this condition ensure for the first iteration and also if in other iterations at least 1 element will be present so LCS should always be <=1
                prevSmallestElement = nums[i];
            }

            largestSequence = Math.max(largestSequence, currentSequence);
        }
        return largestSequence;
    }
    //HashSet approach - Optimal appraoch

    public int longestConsecutiveHashSetApproach(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}

