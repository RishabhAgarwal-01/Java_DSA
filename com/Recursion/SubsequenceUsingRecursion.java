package com.Recursion;

import java.util.ArrayList;

public class SubsequenceUsingRecursion {
    public static void main(String[] args) {
        subsequences("", "abc");

        System.out.println(subsequencesList("", "abc"));
    }

    static void subsequences(String p, String str){
        if(str.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch= str.charAt(0);

        //either take the character in the subsequence or leave it

        //take it
       subsequences(p+ch, str.substring(1));
       //leave it
        subsequences(p, str.substring(1));
    }

    static ArrayList<String> subsequencesList(String p, String str){
        if(str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch= str.charAt(0);

        //either take the character in the subsequence or leave it

        //take it
        ArrayList<String> left= subsequencesList(p+ch, str.substring(1));
        //leave it
        ArrayList<String> right = subsequencesList(p, str.substring(1));

        left.addAll(right);
        return left;
    }
}
