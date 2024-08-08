package com.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumOfSubArrayMinimum_leetcode_907 {
    public static int[] NextSmallerElement(int arr[]){
        Stack<Integer> st= new Stack<>();
        int n = arr.length;
       int nse[]= new int[n];
        for(int i =n-1; i>=0;i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
           nse[i] = st.isEmpty() ? n: st.peek(); //here we took n so that when later we will subract the nse[currentindex]- currentindex
            //it don't make it negative index and give me the correct sub array indexes
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
    public int sumSubarrayMins(int[] arr) {
       int nse[] = NextSmallerElement(arr);
       int psee[]= previousSmallerOrEqualElement(arr);
       int total=0;
       int mod= (int) Math.pow(10,9)+7;
       int n= arr.length;

       for(int i=0;i<n;i++){
           int left = i-psee[i];
           int right = nse[i]-i;
           total = (total+ right*left*arr[i] %mod)%mod;
       }
       return total;
    }

}
