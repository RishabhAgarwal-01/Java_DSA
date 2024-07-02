import java.util.Scanner;

public class butterflypatern
{
    public static void butterfly(int rows, int cols)
    {
        //first half of buttefly

        //number of rows
        for(int i=1;i<=rows;i++){

        //stars for first half and before spaces is equal to the number of rows
           for(int stars=1;stars<=i;stars++){
             System.out.print("*");
           }
           //spaces = 2*(totalrows-currentRow) as it gives always even number of spaces in the pattern
           for(int j=1;j<=2*(rows-i);j++){
             System.out.print(" ");
           }

           //stars after the spaces is equal to the number of rows once again
           for(int stars=1;stars<=i;stars++){
            System.out.print("*");
          }
          System.out.println();
        }

        //second half
        for(int i=rows;i>=1;i--){
            for(int stars=i;stars>=1;stars--){
              System.out.print("*");
            }
            for(int j=1;j<=2*(rows-i);j++){
              System.out.print(" ");
            }
            for(int stars=i;stars>=1;stars--){
             System.out.print("*");
           }
           System.out.println();
         }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        butterfly(rows, cols);
        sc.close();
    }
}