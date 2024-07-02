import java.util.Scanner;

public class InvertedRotatedTriangle {
    public static void IRTriangle(int rows, int col)
    {
      for(int i=1;i<=rows;i++)
      {
         for(int j=1;j<=col-i;j++){ //this print the number of spaces which is eqivalent to totalCol-currentRow number
            //in a matrix imagined
            System.out.print(" ");
         }
         for(int stars=1;stars<=i;stars++){
            System.out.print("*");
         }
         System.out.println();
      }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int rows=sc.nextInt();
        int col= sc.nextInt();
        IRTriangle(rows,col);
        sc.close();
    }
}
