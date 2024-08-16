package com.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combination_Of_Phone_Number_Leetcode_17 {
    public List<String> letterCombinations(String digits) {
       Map<Character,String> map = getMap();
       List<String> ans= new ArrayList<>();
       if(digits.length()==0) return ans;
       getCombos(digits, 0,"", ans, map);
       return ans;
    }

    static void getCombos(String digits,int index,String s, List<String> ans, Map<Character, String> map){
        if(index==digits.length()){
            ans.add(s);
            return;
        }
        for(char ch: map.get(digits.charAt(index)).toCharArray()){
            String temp= new String(s);
            temp+=ch;
            getCombos(digits, index+1,temp,ans,map);
        }
    }

    static Map<Character, String> getMap(){
      Map<Character, String> map= new HashMap<>();
      map.put('2',"abc");
      map.put('3',"def");
      map.put('4',"ghi");
      map.put('5',"jkl");
      map.put('6',"mno");
      map.put('7',"pqrs");
      map.put('8',"tuv");
      map.put('9',"wxyz");
      return map;
    }
}
