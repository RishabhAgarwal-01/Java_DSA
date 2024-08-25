
//The lower bound is the smallest index, ind, where arr[ind] >= x.
// But if any such index is not found, the lower bound algorithm returns n i.e. size of the given array.
public class lowerbound {
    public static int findLowerBound(int arr[], int target, int length){
        int low=0;
        int high = length-1;
        int ans = length;
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid] >= target){
                ans = mid;
                high=mid-1;
            }else {
                low=  mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 5, 7, 9, 9, 11, 13};
        int target = 4;
        int lowerBoundIndex = lowerbound.findLowerBound(arr, target, arr.length);

        System.out.println("Lower bound index: " + lowerBoundIndex);
        if (lowerBoundIndex < arr.length) {
            System.out.println("Lower bound value: " + arr[lowerBoundIndex]);
        } else {
            System.out.println("Lower bound does not exist in the array.");
        }
    }
}
