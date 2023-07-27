package p0036;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        var cols = board[0].length;
        var rows = board.length;

        // Check cols
        for (int j = 0; j < 9; j++) {
            var set = new HashSet<Character>();
            for (int i = 0; i < 9; i++) {
                System.out.println("Elem ["+i+"]["+j+"]");
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }

        // Check rows
        for (int i = 0; i < 9; i++) {
            var set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                System.out.println("Elem ["+i+"]["+j+"]");
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }

        System.out.println("Subboards");
        for (int subboard = 0; subboard < 9; subboard += 3) {
            int rowStart = 0;
            int rowEnd = rowStart + 3;
            for (int idx = 0; idx < 9; idx +=3) {
                int colStart = idx;
                int colEnd = idx + 3;

                var set = new HashSet<Character>();
                for (int i = rowStart; i < rowEnd; i++) {
                    for (int j = colStart; j < colEnd; j++) {
                        System.out.println("Elem ["+i+"]["+j+"]");
                        if (board[i][j] != '.' && !set.add(board[i][j])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(solution.isValidSudoku(board));
    }
}