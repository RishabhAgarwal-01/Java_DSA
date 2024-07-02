import java.util.Arrays;

public class NextPermutation_leetcode31 {
    public void nextPermutation(int[] nums) {
        int n= nums.length;

        int dip =-1;
        //finding the first dipping point from the back of the array such that nums[i] < nums[i+1]
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]) {
                dip = i;
                break;
            }
        }

        //edge case if the array is in descending order
        if(dip ==-1){
            int start = 0;
            int end =n - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
            return;
        }

        //if not then we will choose the next greater number from the end of the array as now the right hand of dip must
        //be sorted in descending order than the dip value and swap it with the dip.
        for(int i=n-1;i>dip;i--){
            if(nums[dip] < nums[i]){
                int temp=0;
                temp = nums[dip];
                nums[dip] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        //reversing the right portion of the dipped index to get the shortest next number
        int start = dip+1, end = n-1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        NextPermutation_leetcode31 solution = new NextPermutation_leetcode31();
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 3, 2]

        nums = new int[]{3, 2, 1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 2, 3]

        nums = new int[]{1, 1, 5};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 5, 1]
    }
}
