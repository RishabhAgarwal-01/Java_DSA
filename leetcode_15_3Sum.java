import java.util.*;

public class leetcode_15_3Sum {
    //firstApproach is brute force for the three loops and storing ans in a set to avoid the
    //duplication

    //second approach is the hashing technique for the 3rd loop
    public List<List<Integer>> threeSumHashing(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            map.clear();
            for(int j=i+1;j< nums.length;j++){
                int sum = -(nums[i]+nums[j]);
                if(map.containsKey(sum)){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(sum);
                    triplet.sort(Integer::compareTo); // Sort the triplet to avoid duplicates
                    set.add(triplet);
                }
                else {
                    map.put(nums[j], j);
                }
            }
        }
        ans.addAll(set);
        return ans;
    }

    //3rd and optimal approach will be two pointer approach for the j and k while keeping i fized and moving
    //it in a loop. j=i+1 AND k= n-1(last element) and they will move towards each other while preventing
    //the duplication of both j and k
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
           int j=i+1;
           int k= nums.length-1;
           while(j<k){
               int sum = nums[i]+ nums[j] + nums[k];
               if(sum < 0){
                   j++;
               } else if (sum >0) {
                   k--;
               }else {
                   List<Integer> triplet = List.of(nums[i], nums[j], nums[k]);
                   ans.add(triplet);
                   j++;
                   k--;
                   while(j<k && nums[j] == nums[j-1]) j++;
                   while (j<k && nums[k] == nums[k-1]) k--;
               }
          }
        }
        return ans;
    }
}
