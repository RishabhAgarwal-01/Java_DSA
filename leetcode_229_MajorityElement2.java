import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_229_MajorityElement2 {

        public List<Integer> majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int min= (int) (nums.length/3)+1;
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                int value = map.getOrDefault(nums[i], 0);
                map.put(nums[i],value+1);
                if(map.get(nums[i])==min){
                    list.add(nums[i]);
                }
                //the answer will have at max 2 element suppose 8 is the length 8/3 +1 = 3 and if there
                //will be more than 2 element which occur 3 or more times than 3+3+3 =9 which is > 8
                if (list.size() == 2) break;
            }
            return list;
        }

}
