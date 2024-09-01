public class leetcode_1283_FindTheSmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxNumber= Integer.MAX_VALUE;
        for(int num:nums){
            maxNumber = Math.max(num, maxNumber);
        }
        int low = 1;
        int high =maxNumber;
        int ans= Integer.MAX_VALUE;
        while(low<=high){
            int mid= (low+high)/2;
            if(DivisonSum(nums, mid) <= threshold){
                ans= mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public int DivisonSum(int[] nums, int divisor){
        int sum=0;
        for(int num:nums){
            sum+= (int)num/divisor;
        }
        return sum;
    }
}
