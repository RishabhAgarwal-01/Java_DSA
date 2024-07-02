import java.util.ArrayList;

public class RearrangeArrayElementsByLine_leetcode_2149 {
    public static  int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                pos.add(nums[i]);
            }
            if(nums[i]< 0){
                neg.add(nums[i]);
            }
        }
        System.out.println("postive list" + pos);
        System.out.println("negative list"+ neg);

        int j=0, k=0;
        for(int i=0;i<nums.length;i++){

            if(i%2 ==0){
                nums[i] = pos.get(j);
                j++;
            }
            else{
                nums[i]= neg.get(k);
                k++;
            }
        }
        return nums;

    }
    public static void main(String args[]) {
        // Array Initialisation.
        int n = 4;
        int A[] = {1, 2, -4, -5};


        int[] ans = rearrangeArray(A);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
