package com.Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class leetcode_767_REorganizeSTring {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        int n = s.length();
        for(char ch : s.toCharArray()){
            int count = freq.getOrDefault(ch,0) +1;
            //if freq of any character is greater than n+1/2 then it would be impossible to reorganzie them
            //as questions wanted
            if(count > (n+1)/2) {
                return "";
            }
            freq.put(ch,count);
        }

        //we have taken the int[] because in priority queue we are storing the pairs of (ch, freq)
        //in the priority queue, we could have used the object of some class but this is good enough

        //also maintain the max heap by giving the comaprator (a,b) -> b[0] - a[0]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (char c : freq.keySet()) {
            pq.add(new int[] {freq.get(c), c}); //{frequency, character}
        }

        //build the result
        StringBuilder ans = new StringBuilder();
        while (pq.size() >= 2){ //>=2 because if it is 1 then the string is of like this aaaaa or a or aa and we have already returned with n+1/2 condition from there
            int[] first = pq.poll(); // pop 2 elements becuase we now know length of pq >=2 atleast
            int[] second = pq.poll();

            //add the elements in the ans
            ans.append((char) first[1]);
            ans.append((char) second[1]);

            //reduce the frequency of the pairs by 1
            first[0] --;
            second[0] --;

            //we again have to add these pairs as we have polled them but only when the frequency > 0
            if (first[0] > 0){
                pq.add(first);
            }

            if (second[0] > 0){
                pq.add(second);
            }
        }
        //this condition if for cases like a i.e where only single element are present then we do this
        //because they will pass the first check but not in second where pq.size>=2 to proceed
        if(!pq.isEmpty()) {
            int[] first  = pq.poll();

            ans.append((char) first[1]);
        }

        return ans.toString();
    }
}
