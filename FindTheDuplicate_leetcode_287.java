import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicate_leetcode_287 {
    //we can use this approach to store the frequency of each element in a seperate array freq of size n
    //and return the index of the repeated element but it will take O(N) complexity
    static int findDuplicateHashing(int[] arr) {
        int n = arr.length;
        int freq[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (freq[arr[i]] == 0) {
                freq[arr[i]] += 1;
            } else {
                return arr[i];
            }
        }
        return 0;
    }

    //second apprach is the fast slow pointer method of Linked List implemented in the arrays.
    //we will jump using the values stored in the array and at one point the fast and slow pointer will surely collide
    // then from the point of collision place the fast pointer at start and slow pointer at the collison positon
    //after that move each of them 1 step each. When the second collison will happen it will be the point of duplicate number


    public int findDuplicate(int[] nums) {
       int slow = nums[0];
       int fast = nums[0];

       do {
           slow= nums[slow];
           fast = nums[nums[fast]];
       }while(slow != fast);

       fast= nums[0];

       while (slow != fast){
           slow= nums[slow];
           fast= nums[fast];
       }
       return slow;
    }

    //anotherAppraoch is the use of HashSet
    public int findDuplicateHashset(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1; // This line should never be reached if there's guaranteed to be a duplicate
    }
}
