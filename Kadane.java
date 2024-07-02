//finding the max sub array sum using kadane for faster processing
public class Kadane {
    public static void maxSubArraySum(int arr[])
    {
        int maxSum= arr[0]; //we take first element as maxSum initially
        int currentSum= arr[0]; //currentSum value is also first element initially 
        for(int i=1;i<arr.length;i++){
           currentSum = Math.max(arr[i] , currentSum + arr[i]);
           maxSum= Math.max(currentSum , maxSum);
        }
          System.out.println(maxSum);
    }
    public static void main(String[] args) {
        int arr[]= {-2,-3,4,-1,-2,1,5,-3};
        maxSubArraySum(arr);
    }

}
