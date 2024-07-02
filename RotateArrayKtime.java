import java.util.Arrays;

public class RotateArrayKtime {
    public static void rotate(int[] nums, int k) {
        k = k% nums.length; //This gives the index after which the elements have to be placed at the beginning of array
        int left=0, right=nums.length-1;
        while(left < right){
            int temp;
            temp = nums[left];
            nums[left] =nums[right];
            nums[right] = temp;
            left ++; right --;
        }
        left=0; right=k-1;
        while(left < right){
            int temp;
            temp = nums[left];
            nums[left] =nums[right];
            nums[right] = temp;
            left ++; right --;
        }
        left=k; right=nums.length-1;
        while(left < right){
            int temp;
            temp = nums[left];
            nums[left] =nums[right];
            nums[right] = temp;
            left ++; right --;
        }

    }
      public static void main(String[] args) {
        int nums[]= {1,2,3,4,5};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

}
