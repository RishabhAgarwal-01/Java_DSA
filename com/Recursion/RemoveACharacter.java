package com.Recursion;

public class RemoveACharacter {
    public static void main(String[] args) {
        String str ="bbaccda";
        System.out.println(remove('a', str));

        String str2= "bbaccaappleamk";
        System.out.println(removeString("apple", str2));
    }
    static String remove(char ch, String str){
        if(str.isEmpty()) return "";
        char c= str.charAt(0);
        if(c==ch){
            return remove(ch, str.substring(1));
        }
        else {
            return c+remove(ch,str.substring(1));
        }
    }

    static String removeString(String s, String str){
        if(str.isEmpty()) return "";
        char ch= str.charAt(0);
        if(str.startsWith(s)){
            return removeString(s ,str.substring(s.length()));
        }
        else {
            return ch+removeString(s,str.substring(1));
        }
    }
}
