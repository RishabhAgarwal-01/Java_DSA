public class FirstUniqueCharacterInAString_leetcode_387 {

    //this approach include the taking a array of 26 size and then using the a=97 ASCII value and calculating the
    //index for the character to increase it freq. then again travel the array left to right and as the freq =1 for the first
    //character of the character array arr return the index i
    public int firstUniqChar(String s) {
        char[] arr= s.toCharArray();
        int[] freq= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            char ch= arr[i];
            int index= (int)ch-97;
            freq[index]= freq[index]+1;
        }

        for (int i=0;i<arr.length;i++){
            char ch= arr[i];
            int index= (int)ch-97;
            if(freq[index]==1){
                return i;
            }
        }
        return -1;
    }
}
