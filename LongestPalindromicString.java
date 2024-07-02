public class LongestPalindromicString {
    public static  boolean isPalindrome(String str){

        StringBuilder reversedString = new StringBuilder(str).reverse();
        String s= reversedString.toString();
        if(str.equals(s)){
            return true;
        }
        return false;
    }
    public static  String longestPalindrome(String s) {
        if(s.length() ==0){
            return s;
        }
       int length = s.length();
       int i=0;
       String subString="";
       while (i<length){
           subString =s.substring(i,length);
           boolean check = isPalindrome(subString);
           if(check)
               break;
           i++;
           length--;
       }
       return subString;
    }

    public static void main(String[] args) {
        String s =longestPalindrome("babad");
        System.out.println(s);
    }
}
