public class DiagonalSum {
    public static void DSum(int matrix[][],int num)
    {
        int leftDiagonal=0, rightDiagonal=0;

        for(int i=0;i<=num-1;i++)
        {
            for(int j=0;j<=num-1;j++)
            {
                if(i==j) //primary or left diagonal
                {
                    leftDiagonal+=matrix[i][j];
                }
                if(i+j==(num-1)) //secondary or right diagonal
                {
                    rightDiagonal+=matrix[i][j];
                }
            }
        }
        System.out.println("left Diagonal: "+leftDiagonal+" right diagonal: "+rightDiagonal);
    } 
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        DSum(matrix, 4);
    }
}
