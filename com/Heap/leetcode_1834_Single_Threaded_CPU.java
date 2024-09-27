package com.Heap;

import java.util.*;

public class leetcode_1834_Single_Threaded_CPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // Create a list to store tasks with their original indices
        List<int[]> sortedTasks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int startTime = tasks[i][0];
            int duration = tasks[i][1];
            sortedTasks.add(new int[]{startTime, duration, i});
        }

        // Sort tasks by start time first and then by processing time if they are equal
        Collections.sort(sortedTasks, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Sort by start time
            }
            return Integer.compare(a[1], b[1]); // If equal, sort by processing time
        });

        int[] result = new int[n];
        int arrVar = 0; // Index for result array

        long currTime = 0;
        int idx = 0; // Index of sorted tasks

        // Min-heap to store available tasks based on their processing times and indices
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Sort by processing time
            }
            return Integer.compare(a[1], b[1]); // If processing time is equal, sort by index
        });

        while (idx < n || !minHeap.isEmpty()) {
            // If no tasks are available in the heap and current time is less than the next task's start time
            if (minHeap.isEmpty() && currTime < sortedTasks.get(idx)[0]) {
                currTime = sortedTasks.get(idx)[0]; // Jump forward in time
            }

            // Add all tasks that can be started at or before current time
            while (idx < n && sortedTasks.get(idx)[0] <= currTime) {
                minHeap.offer(new int[]{sortedTasks.get(idx)[1], sortedTasks.get(idx)[2]}); // Add processing time and index
                idx++;
            }

            // If there are available tasks to process
            if (!minHeap.isEmpty()) {
                int[] currTask = minHeap.poll(); // Get the task with the smallest processing time
                currTime += currTask[0]; // Update current time with processing time
                result[arrVar++] = currTask[1]; // Add the index of the processed task to result
            }
        }

        return result;
    }
}
