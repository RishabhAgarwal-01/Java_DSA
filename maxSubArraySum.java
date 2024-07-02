import java.util.Arrays;

public class maxSubArraySum {
    //we use the PREFIX array for the finding the max sum among all the subarrays possible
    //the PREFIX ARRAY is a simple array which contain the sum of all the preceding + indexed Element at that index
    //we can simply use this array to calculate the max sub array sum using formula
    //prefix[end]-prefix[start-1] 
    //this will give us sum for each possible sub arrays for a starting and ending index and we can comapre them for max
    public void prefixTechnique(int num []){
        int prefix[]= new int[num.length];
        for(int i=1;i<num.length;i++){
            prefix[i]=prefix[i-1]+ num[i]; //this calculate the prefix array
        } 
        int maxSum=0;//max sum
        //for starting index of the array
        for(int i=0;i<num.length;i++){
           int start=i;

            //for end index
            for(int j=0;j<num.length;j++){
                int end=j;
                int currentSum=0; //current sub array sum
                 currentSum = start==0 ? prefix[end] : prefix[end]-prefix[start-1]; 
                 if(maxSum<currentSum)
                 {
                    maxSum=currentSum;
                 }
            }
        }
        System.out.println("The max sub array sub for the given array" + Arrays.toString(num) + "is :"+ maxSum);
    }
    public static void main(String[] args) {
        int num[]={1,-2,3,-4,-5,-6,7};
        maxSubArraySum obj= new maxSubArraySum();
        obj.prefixTechnique(num);
    }
}
