package com.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode_1962_remove_stone {
    public int minStoneSum(int[] piles, int k) {
        int count=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int pile : piles) {
            pq.add(pile);
            count += pile;
        }

        for(int i=0;i<k;i++){
         int top = pq.poll();
         int removing = top/2; //this will be removed which is floor(piles[i])
         int remaining = top-removing; //this will remain after the value is removed from that stone
         count-= removing;
         pq.add(remaining);
        }
        return count;
    }
}
