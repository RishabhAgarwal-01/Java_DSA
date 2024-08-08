package com.stackandqueue;

import java.util.Stack;

public class LargestRectangleInHistogram_leetcode_84 {
    //find the nextSmallerElement for each
    public static int[] nextSmallerElement(int arr[]){
        Stack<Integer> st= new Stack<>();
        int n = arr.length;
        int nse[]= new int[n];
        for(int i =n-1; i>=0;i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n: st.peek(); //here we took n so that when later we will subract the nse[currentindex]- currentindex
            //it do not make it negative index and give me the correct sub array indexes
            st.push(i);
        }
        return nse;
    }

    public static int[] previousSmallerOrEqualElement(int arr[]){
        Stack<Integer> st= new Stack<>();
        int n = arr.length;
        int psee[]= new int[n];
        for(int i =0; i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            psee[i]= st.isEmpty()?-1:st.peek(); //here we can take -1 because 1-(-1)=2 still result in poitive index
            st.push(i);
        }
        return psee;
    }

    public int largestRectangleArea(int[] heights) {
        int nse[] = nextSmallerElement(heights);
        int psee[]= previousSmallerOrEqualElement(heights);
        int n= heights.length;
        int rect[]= new int[n];
        int maxRect= heights[0]*(nse[0]-psee[0]-1);
        for(int i=1;i<n;i++){
           rect[i] = heights[i]*(nse[i]-psee[i]-1);
           maxRect= Math.max(maxRect, rect[i]);
        }
       return maxRect;
    }

}
