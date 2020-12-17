package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buyi@gegejia.com
 * @date 2020-11-04 : 17:51
 */




public class _54_SpiralMatrix {





    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        _54_SpiralMatrix spiralMatrix = new _54_SpiralMatrix();

        List<Integer> a = spiralMatrix.spiralOrder(matrix);
        List<Integer> b = spiralMatrix.spiralOrder(matrix);

    }



    public List<Integer> spiralOrder(int[][] matrix) {


        int rows = matrix.length;
        int lines = matrix[0].length;

        List<Integer> results = new ArrayList<>();

        int j = 0;
        int k = 0;

        int start_column = 0;
        int end_column = rows-1;
        int start_line = 0;
        int end_line = lines-1;

        for (int i=0;i<rows*lines;i++) {

            results.add(matrix[k][j]);
            if (k == end_line) {
                if (j == start_column) {
                    start_column ++;
                    k --;
                } else {
                    j --;
                }
                continue;
            }

            if (j == end_column) {
                if (k == end_line) {
                    start_line ++;
                    j --;
                } else {
                    k ++;
                }
                continue;
            }

            if (k == start_line) {
                if (j == end_column) {
                    end_column --;
                    k ++;
                } else {
                    j ++;
                }
                continue;
            }

            if (j == start_column) {
                if (k == start_line) {
                    end_line --;
                    j ++;
                } else {
                    k --;
                }
                continue;
            }
        }

        return results;
    }
}
