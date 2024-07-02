//This program finds the happy number using the cycle detection technique of linked list cycle detection.
//the idea is to calculate the slow and fast value for happy number where a slow one will calculate for one time and fast
//will do it for 2 times calling the sqaring function two times.

//Happy number is a number which becomes 1 eventually after repeated sum of the sqaure of it's degits like 23
//2*2 +  3*3 => 13 => 1*1 + 3*3 =1
public class HappyNumber {
    public boolean isHappy(int n) {
        int fast = n;
        int slow =n;

        do {
            slow= findSquare(slow);
            fast= findSquare(findSquare(fast));
        } while (slow != fast);

        if(slow == 1)
        {
            return true;
        } 
        return false;
        
    }
    private int findSquare(int num) {
        int ans=0;
        while(num>0){
            int rem= num %10;
            ans += rem * rem;
            num /=10;
        }
        return ans;
    }
    public static void main(String[] args) {
        HappyNumber obj= new HappyNumber();
        boolean ans= obj.isHappy(35);
        if(ans==true) 
          System.out.println("Happy");
        else 
          System.out.println("Not happy no.");
    }
}
