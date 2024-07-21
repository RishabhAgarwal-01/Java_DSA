package com.Recursion;

public class isArraySorted {
  public static boolean helper(int arr[], int index, int length){
      if(index==length-1){
          return true;
      }
      if(arr[index] < arr[index+1] && helper(arr,index+1,length )){
          return true;
      }
      return false;
  }
  public static boolean sort(int arr[], int length){
      return helper(arr, 0, length);
  }

    public static void main(String[] args) {
        int arr [] ={97,871,134,1};
        System.out.println(sort(arr, arr.length));
    }
}
