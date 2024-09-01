import java.util.Arrays;

public class leetcode_875_kokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int maxElementInPiles = Arrays.stream(piles).max().getAsInt();
        int low = 1;
        int high =maxElementInPiles;
        int ans= Integer.MAX_VALUE;
        while(low<=high){
            int mid= (low+high)/2;
            if(findTotaltime(piles, mid) <= h){
                ans= mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    public int findTotaltime(int piles[], int speed){
        int totalHours = 0;
        for(int i=0;i<piles.length;i++){
            totalHours+= Math.ceil((double)piles[i]/(double)speed);
        }
        return totalHours;
    }
}
