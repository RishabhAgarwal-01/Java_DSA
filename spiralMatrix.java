public class spiralMatrix {
    public static void spiral(int matrix[][])
    {
        int row= matrix.length;
        int col = matrix[0].length;

        int StartRow=0, EndRow=row-1;
        int StartCol=0, EndCol=col-1;

        while(StartRow<=EndRow && StartCol<=EndCol)
        {
            //top
            for(int j=StartCol;j<=EndCol;j++){
                  System.out.print(matrix[StartRow][j]+"\t");
            }
            StartRow++;
            
            //right
            for(int i=StartRow;i<=EndRow;i++){
                System.out.print(matrix[i][EndCol]+"\t");
            }
            EndCol--;

            //bottom
            if(StartRow <= EndRow){
            for(int j=EndCol;j>=StartCol;j--){
                System.out.print(matrix[EndRow][j]+"\t");
            }
            EndRow--;
        }
            
            //left
            if(StartCol<=EndCol){
            for(int i=EndRow;i>=StartRow;i--){
                System.out.print(matrix[i][StartCol]+"\t");
            }
            StartCol++;
        }
        }
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        spiral(matrix);
    }
}
