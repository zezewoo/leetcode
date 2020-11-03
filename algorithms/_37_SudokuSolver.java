package algorithms;

import java.util.*;

/**
 * @author wxb
 * @date 2020-10-28 : 17:12
 */
public class _37_SudokuSolver {


    public static void main(String[] args) {

        _37_SudokuSolver sudokuSolver = new _37_SudokuSolver();


        char[][] board =
                {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};

        sudokuSolver.solveSudoku(board);

    }


    public void solveSudoku(char[][] board) {

        Character[] strings = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Set<Character> all = new HashSet<>(Arrays.asList(strings));

        Map<String, Set<Character>> table = new HashMap<>();

        Map<String, Set<Character>> tableRemain = new HashMap<>();


        for (int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {

                char c = board[i][j];
                String keyR = "_._"+i+j;

                String key = "_l"+i;
                Set<Character> characters = table.get(key);
                if (characters == null) {
                    characters = new HashSet<>();
                }
                table.put(key, characters);


                String keyB = "_r"+j;
                Set<Character> charactersB = table.get(keyB);
                if (charactersB == null) {
                    charactersB = new HashSet<>();
                }
                table.put(keyB, charactersB);


                String keyC = "_box" + i / 3 + "_" + j / 3;
                Set<Character> charactersC = table.get(keyC);
                if (charactersC == null) {
                    charactersC = new HashSet<>();
                }
                table.put(keyC, charactersC);

                if (c != '.') {

                    Set<Character> remain = new HashSet<>();
                    remain.add(c);
                    tableRemain.put(keyR, remain);

                    characters.add(c);
                    table.put(key, characters);

                    charactersB.add(c);
                    table.put(keyB, charactersB);

                    charactersC.add(c);
                    table.put(keyC, charactersC);
                } else {

                    Set<Character> remain = new HashSet<>(Arrays.asList(strings));
                    tableRemain.put(keyR, remain);
                }
            }
        }



        int size  = 0;
        int preSize = size;

        boolean flag = false;

        while (size != 81) {

            size = 0;
            for (Map.Entry<String, Set<Character>> entry: tableRemain.entrySet()) {
                size += entry.getValue().size();
            }
            if (preSize == size) {
                flag = true;
            } else {
                flag = false;
            }
            preSize = size;

            System.out.println("run again, size = " + size);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    char c = board[i][j];
                    System.out.print(c);
                    if ((j+1)%9==0) {
                        System.out.println();
                    }

                    if (c == '.') {

                        Set<Character> remain = new HashSet<>(Arrays.asList(strings));

                        String key = "_l" + i;
                        Set<Character> characters = table.get(key);

                        String keyB = "_r" + j;
                        Set<Character> charactersB = table.get(keyB);


                        String keyC = "_box" + i / 3 + "_" + j / 3;
                        Set<Character> charactersC = table.get(keyC);

                        if (characters != null) {
                            remain.removeAll(characters);
                        }

                        if (charactersB != null) {
                            remain.removeAll(charactersB);
                        }

                        if (charactersC != null) {
                            remain.removeAll(charactersC);
                        }

                        String keyR = "_._" + i + j;
                        tableRemain.put(keyR, remain);

                        if ((remain.size() == 1)) {
                            Character r = (Character) remain.toArray()[0];
                            board[i][j] = r;

                            characters.add(r);
                            table.put(key, characters);

                            charactersB.add(r);
                            table.put(keyB, charactersB);

                            charactersC.add(r);
                            table.put(keyC, charactersC);
                        }

                        if ((remain.size() == 2) && flag) {
                            Character r = (Character) remain.toArray()[0];
                            board[i][j] = r;

                            characters.add(r);
                            table.put(key, characters);

                            charactersB.add(r);
                            table.put(keyB, charactersB);

                            charactersC.add(r);
                            table.put(keyC, charactersC);
                        }

                    }
                }
            }
        }


        System.out.println(board.toString());
    }
}
