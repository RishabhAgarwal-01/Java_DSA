import java.util.Scanner;
 class Hollow
{
    public void Hollow_rectangle(int row, int col)
    {
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(i==1 || j==1 || i==row || j==col){ //here we are printing the boundary element using this
    //boundary element have either or both row and col=1 or last given number of row or col.
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }
}
public class HollowRectangle{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int row, col;
        System.out.println("Enter the number of row");
        row=sc.nextInt();
        System.out.println("Enter the number of columns");
        col=sc.nextInt();
        Hollow hollow= new Hollow();
        hollow.Hollow_rectangle(row, col);
        sc.close();
    }
}