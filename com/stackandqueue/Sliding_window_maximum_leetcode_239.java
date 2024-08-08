package com.stackandqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Sliding_window_maximum_leetcode_239 {
    //naive approach O(n+k)*k complexity but will get the TLE for very large numbers of elements
    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<=nums.length-k;i++){
            int max=nums[i];
            for(int j=i;j<i+k;j++){
                max= Math.max(max,nums[j]);
            }
            list.add(max);
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[]= new int[nums.length -k +1];
        int j=0; //just for res array
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty() && nums[queue.getLast()]< nums[i]){ //if the stored element is smaller than the incoming element
                queue.removeLast(); //remove from the back,
                //also we condier that the if incoming element is smaller it still has a chance to be in the result array
            }
            //add the element in the last
            queue.addLast(i);
            //it checks that if the window size is complete and window move 1 point forward
            //then remove the  first of the queue as it is no longer part of window
            if(queue.getFirst()+k ==i){
                //then remove the  first of the queue as it is no longer part of window
               queue.removeFirst();
            }
            //start storing the elements in the res once the first window is completed
            if(i>=k-1){
                res[j++]= nums[queue.getFirst()];
            }
        }
        return res;
    }
}
