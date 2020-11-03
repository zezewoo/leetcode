package algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wxb
 * @date 2020-10-28 : 16:46
 */
public class _36_ValidSudoku {


    public boolean isValidSudoku(char[][] board) {

        Set<String> table = new HashSet<>();

        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!table.add(c + "row" + i) ||
                        !table.add(c + "line" + j) ||
                        !table.add(c + "box"+i/3+"-"+j/3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }




}
