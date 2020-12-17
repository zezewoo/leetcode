package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author buyi@gegejia.com
 * @date 2020-11-06 : 15:47
 */
public class _51_NQueens {


    public static void main(String[] args) {

        _51_NQueens nQueens = new _51_NQueens();
        nQueens.solveNQueens(5);

    }



    public List<List<String>> solveNQueens(int n) {

        int[] x = new int[n];
        backTrace(1, n, x);
        return null;
    }



    public void backTrace(int r, int n, int[] x) {

        if (r > n) {
            return;
        }

        for (int i=1;i<n;i++) {
            if (canPlace(r, i, x)) {
                x[r] = i;
                backTrace(r+1, n, x);
            }
        }
    }




    public boolean canPlace(int r, int i, int[] x) {
//         if (x[r]  ) {
//
//         }
        return false;
    }


























    public List<List<String>> composeResult(List<int[][]> list) {

        List<List<String>> results = new ArrayList<>();

        for (int[][] matrix : list) {
            List<String> aa = new ArrayList<>();
            for (int i=0;i<matrix.length;i++) {
                String str = new String();
                for (int j=0;j<matrix[0].length;j++) {
                    str += matrix[i][j] == 0?".":"Q";
                }
                aa.add(str);
            }
            results.add(aa);
        }

        return results;
    }


}
