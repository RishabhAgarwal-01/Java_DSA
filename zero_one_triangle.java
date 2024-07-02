import java.util.Scanner;
//While observing the patern in the matrix form we can see wherever the sum of row and col is even there is 1 and where 
//it is odd it is printed 0. Additionally we also check the number of rows and cols to be printed.
public class zero_one_triangle 
{
  public static void ztTriangle(int rows, int cols)
  {
    for(int i=1;i<=rows;i++)
    {
        for(int j=1;j<=i;j++)
        {
            if((i+j)%2==0)
              System.out.print("1");
            else
             System.out.print("0");
        }
        System.out.println();
    }
  }   
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int rows=sc.nextInt();
    int cols= sc.nextInt();
    ztTriangle(rows, cols);
    sc.close();
  } 
}
