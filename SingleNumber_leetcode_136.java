import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber_leetcode_136 {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            int storedValue = map.getOrDefault(nums[i],0);
            map.put(nums[i], storedValue+1);
        }

        //Iterating for each entry and getting a single key value pair each time and then comapring the value ==1
        for(HashMap.Entry<Integer, Integer> oneEntry : map.entrySet()){
            if(oneEntry.getValue() ==1){
                return oneEntry.getKey();
            }
        }

        return -1; //this line will never execute if the array contains each element twice and only one element one time
    }
}
