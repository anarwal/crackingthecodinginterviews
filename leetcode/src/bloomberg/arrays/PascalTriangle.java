package bloomberg.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        List<Integer> rowF = new ArrayList<Integer>();
        rowF.add(1);
        result.add(rowF);

        for(int i=1; i<numRows; i++){
            List<Integer> rowP = result.get(i-1);
            List<Integer> rowC = new ArrayList<Integer>();

            rowC.add(1);
            for(int j=1; j<i;j++){
                rowC.add(rowP.get(j-1)+rowP.get(j));
            }
            rowC.add(1);
            result.add(rowC);
        }
        return result;
    }
}
