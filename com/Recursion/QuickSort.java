package com.Recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] arr={5,4,3,2,1,78,90,3,5,67,1,6,3,89,55,4};
//       int [] ans =mergeSortCopy(arr);
//       System.out.println(Arrays.toString(ans));
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] nums, int low, int high){

        if(low>=high){
            return;
        }

        int s=low;
        int e= high;
        int mid= s+(e-s)/2;
        int pivot= nums[mid];

        while(s<=e){
            while(nums[s]<pivot){
                s++;
            }
            while(nums[e]>pivot){
                e--;
            }
            //just in case to ensure that s<=e as while condition might not run until
            //later when the whole body finished executing
            if(s<=e){
                int temp=nums[s];
                nums[s]=nums[e];
                nums[e]= temp;
                s++;
                e--;
            }
        }
        sort(nums,low,e);
        sort(nums, s, high);
    }
}
