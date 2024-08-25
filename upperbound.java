//But if any such index is not found, the upper bound algorithm returns n i.e.
// size of the given array. The main difference between the lower and upper bound is in the condition.
// For the lower bound the condition was arr[ind] >= x and here, in the case of the upper bound,
// it is arr[ind] > x.
public class upperbound {
    public int findUpperBound(int arr[], int target, int len){
        int low= 0;
        int high = arr.length-1;
        int ans = len;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>target){
                ans = mid;
                high = mid-1;
            }
            else {
               low= mid+1;
            }
        }
        return ans;
    }
}
