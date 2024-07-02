import java.util.Scanner;

public class SolidRhombus
{
    //n denotes the number of rows as well as the number of stars to be printed in one row of the pattern
    public static void Rhombus(int n){

        //outer loop for controlling spaces and stars
        for(int i=1;i<=n;i++){

            //inner loop for the spaces control
            for(int spaces=1;spaces<=n-i;spaces++){
                System.out.print(" ");
            }

            //inner loop to print n stars in every row
            for(int stars=1;stars<=n;stars++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        Rhombus(n);
        sc.close();
    }
}