package com.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode_1046_Smash_stones {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int result=0;
        for (int stone: stones)
            maxHeap.add(stone);

        while (maxHeap.size() > 1){
            int biggest = maxHeap.poll();
            int secondBiggest = maxHeap.poll();
            //because if they are equal they will be completely destroyed
            if(biggest != secondBiggest){
                maxHeap.add(Math.abs(biggest - secondBiggest));
            }
        }
        if(maxHeap.size() >0){
            return maxHeap.poll();
        }else {
            return 0;
        }
    }
}
