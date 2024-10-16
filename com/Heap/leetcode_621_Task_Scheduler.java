package com.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode_621_Task_Scheduler {
        public int leastInterval(char[] tasks, int p) {
            // Build frequency map
            int[] freq = new int[26];
            for (char ch : tasks) {
                freq[ch - 'A']++;
            }

            // Max heap to store frequencies
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    pq.offer(freq[i]);
                }
            }

            int time = 0;
            // Process tasks until the heap is empty
            while (!pq.isEmpty()) {
                int cycle = p + 1;
                List<Integer> store = new ArrayList<>();
                int taskCount = 0;
                // Execute tasks in each cycle
                while (cycle-- > 0 && !pq.isEmpty()) {
                    int currentFreq = pq.poll();
                    if (currentFreq > 1) {
                        store.add(currentFreq - 1);
                    }
                    taskCount++;
                }
                // Restore updated frequencies to the heap
                store.forEach(pq::offer);
                // Add time for the completed cycle
                time += (pq.isEmpty() ? taskCount : p + 1);
            }
            return time;
        }
}
