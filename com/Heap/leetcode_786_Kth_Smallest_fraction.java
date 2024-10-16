package com.Heap;

import java.util.PriorityQueue;

public class leetcode_786_Kth_Smallest_fraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)-> Double.compare(b[0], a[0]));
        for(int i=0; i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++) {
                double div = (double) arr[i]/arr[j];
                pq.offer(new double[]{div, (double) arr[i], (double) arr[j]});
                if(pq.size()>k)
                    pq.poll();
            }
        }
        double[] kthSmallest = pq.peek();
        int[] res = new int[2];
        res[0] = (int)kthSmallest[1];
        res[1] = (int)kthSmallest[2];
        return res;
    }
}
