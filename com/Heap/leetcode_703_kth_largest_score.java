package com.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode_703_kth_largest_score {

    //taking min heap so that small remain on top and they are removed before larger
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;
    public leetcode_703_kth_largest_score(int k, int[] nums) {
            this.k = k;
            for(int num: nums){
                minHeap.offer(num);
            }

            //remove the elements if it exceeds the size k
            while (minHeap.size()>k)
                minHeap.poll();
      }

        public int add(int val) {
            minHeap.add(val);
            while (minHeap.size() > k)
                minHeap.poll();
            return minHeap.peek();
        }

        //second appraoch with optimize solution
        class KthLargest {
            private int k;
            private PriorityQueue<Integer> minHeap;

            public KthLargest(int k, int[] nums) {
                this.k = k;
                minHeap = new PriorityQueue<>(k);
                for (int num : nums) {
                    if (minHeap.size() < k) {
                        minHeap.offer(num);
                    } else if (num > minHeap.peek()) {
                        minHeap.offer(num);
                        if (minHeap.size() > k) {
                            minHeap.poll();
                        }
                    }
                }
            }

            public int add(int val) {
                if (minHeap.size() < k) {
                    minHeap.offer(val);
                } else if (val > minHeap.peek()) {
                    minHeap.offer(val);
                    minHeap.poll();
                }
                return minHeap.peek();
            }
        }

}
