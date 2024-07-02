import java.util.Scanner;

public class DiamondPattern{
    public static void DPattern(int n)
    {
         //first half
      for(int i=1;i<=n;i++){  //outer loop for row
          
        //spaces which will be always one less than the current row we are 
        for(int spaces=1;spaces<=n-i;spaces++){
            System.out.print(" ");
        }
        //stars are always odd in the number like for 1st row 1 star, 2nd row 3 stars so 2*currentRow-1
        for(int stars=1;stars<=2*i-1;stars++){
            System.out.print("*");
        }
        System.out.println();
      }

      //2nd half of diamond
      for(int i=n;i>=1;i--){  //outer loop for row
          
        //spaces which will be always one less than the current row we are 
        for(int spaces=1;spaces<=n-i;spaces++){
            System.out.print(" ");
        }
        //stars are always odd in the number like for 1st row 1 star, 2nd row 3 stars so 2*currentRow-1
        for(int stars=1;stars<=2*i-1;stars++){
            System.out.print("*");
        }
        System.out.println();
    }
}
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        DPattern(n);
        sc.close();
    }
}