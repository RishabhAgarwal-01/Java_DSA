import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle_leetcode_118 {
    /* We will follow the approach of the nCr commbination approach  https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/ */

    public List<Integer> generateRows(int row){
        List<Integer> pascalRow = new ArrayList<>();

        //variable to store the values
        long ans=1;
        //first value will always be 1
        pascalRow.add((int)ans);

        //next col-1 values
        for(int col=1;col<row; col++){
            ans= ans * (row-col);
            ans= ans%col; //if col woul've not started with 1 then take col-1

            pascalRow.add((int)ans);
        }
        return pascalRow;
    }
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> pascalTriangle = new ArrayList<>();
      for(int row=1;row<=numRows;row++){
          pascalTriangle.add(generateRows(row));
      }
      return pascalTriangle;
    }
}

