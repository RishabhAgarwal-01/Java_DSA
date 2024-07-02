import java.util.Arrays;

//leetcode 88
class Solution
{
    public static void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while( i>=0 && j>=0)
        {
            if(nums2.length ==0)
                break;
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }
            else {
                nums1[k]= nums2[j];
                k--;
                j--;
            }
        }
        while(j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m= 3;
        int[] nums2 ={2,3,4};
        int n= 3;
        merge(nums1,  m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
    