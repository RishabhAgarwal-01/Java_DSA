package com.Heap;


//Median Definition:
//The median is the middle value in a sorted list of numbers.
// If the list has an odd number of elements, it's the middle element.
// If it has an even number, it's the average of the two middle elements.

import java.util.Collections;
import java.util.PriorityQueue;

//Dynamic Data Stream:
//You will be receiving numbers one by one, and after each insertion,
// you need to be able to quickly compute the median of all numbers added up to that point.
public class leetcode_295_Find_media_from_data_stream {
    //stores and maintains the maxheap for the left side elements as it is being given ans essestially sorting them
    //in max order so that the greatest element of the left side at any particular point remains at the top
    PriorityQueue<Integer> leftMaxHeap ;

    //stores and maintain the min heap for the right side elements such that the top element is the smallest
    //among all right side elements at any given point particularly useful when asking for the median of even
    PriorityQueue<Integer> rightMinHeap;

    public leetcode_295_Find_media_from_data_stream() {
        leftMaxHeap =  new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //if left is empty or the element to be inserted is smaller than the left heaps peek element that
        //essentially means that it must be on the left side because it is smaller to maintain the sorted order
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else { //else add it to right
            rightMinHeap.add(num);
        }

        // always maintain leftMaxHeap size one greater than rightMinHeap size
        // or both sizes equal
        if (Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            // even number of elements avg of two middle element in case of even
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }

         // odd number of elements just simply return the leftheap top as it is the current middle element in
        //sorted list
         return leftMaxHeap.peek();
    }

}
