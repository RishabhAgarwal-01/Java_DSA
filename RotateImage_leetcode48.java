import java.util.ArrayList;
import java.util.Arrays;

public class RotateImage_leetcode48 {
    public void rotate(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        ArrayList<Integer> mem = new ArrayList<>();

        for (int j = 0; j < cols; j++) {
            for (int i = rows - 1; i >= 0; i--) {
                mem.add(matrix[i][j]);
            }
        }
        System.out.println(mem);

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = mem.get(count);
                count++;
            }
        }
    }

    public static void main(String[] args) {
            // Define and initialize a 2D array with hardcoded values
            int[][] array = {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12}
            };
        RotateImage_leetcode48 obj = new RotateImage_leetcode48();
        obj.rotate(array);
    }

}
