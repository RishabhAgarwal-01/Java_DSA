package com.stackandqueue;

import java.util.Stack;

public class Maximal_Rectangle_leetcode_85 {
    public int largestHistogram(int heights[]){
        Stack<Integer> st= new Stack<>();
        int n= heights.length;
        int nse[]= new int[n];
        int psee[]= new int[n];

        //computing the nextSmallerElement
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            nse[i]=st.isEmpty() ? n: st.peek();
            st.push(i);
        }

        st.clear();

        //computing the previousSmallerOrEqualElement
        //computing the nextSmallerElement
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                st.pop();
            }
            psee[i]=st.isEmpty() ? -1: st.peek();
            st.push(i);
        }

        //computing maximum histogram
        int maxAreaForARow= heights[0]*(nse[0]-psee[0]-1);
        int rect[]= new int[n];
        for(int i=1;i<n;i++){
            rect[i] = heights[i]*(nse[i]-psee[i]-1);
            maxAreaForARow= Math.max(maxAreaForARow, rect[i]);
        }
        return maxAreaForARow;

    }

    public int maximalRectangle(char[][] matrix) {
        int largest=0;
        //array heights of length = number of columns
       int heights[]= new int[matrix[0].length];
       //traverse the matrix to get the previous prefsum for each column by adding the previous values stored in the heights
        //for the particular index and if a index in 2D array is 0 set the height for that index as 0
        for(int i=0;i< matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if((matrix[i][j]-'0')==0){
                    heights[j]=0;
                }
                else{
                    heights[j]+=( matrix[i][j]-'0');
                }
            }
            int maxArea= largestHistogram(heights);
            largest=Math.max(largest,maxArea);
        }
        return largest;
    }
}
