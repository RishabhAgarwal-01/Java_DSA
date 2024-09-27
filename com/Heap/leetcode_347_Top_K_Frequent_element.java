package com.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode_347_Top_K_Frequent_element {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        //Min heap priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) ->
                frequencyMap.get(a) - frequencyMap.get(b));

        // Step 3: Add elements to the min-heap
        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            // If the size of the heap exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // Step 4: Extract results from the min-heap into an array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;

    }
}
