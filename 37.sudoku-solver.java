import java.util.*;

/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */
class Solution {
    public void solveSudoku(char[][] board) {
        Set<Character>[] sudoku = new Set[27];
        for(int i = 0; i < 27; i++){
            sudoku[i] = new HashSet<>();
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j]!='.'){
                    sudoku[i].add(board[i][j]);
                    sudoku[j + 9].add(board[i][j]);
                    sudoku[18 + i / 3 * 3 + j / 3].add(board[i][j]);
                }
            }
        }
        // sudoku[0].remove('1');
        
        backtracking(board, 0, 0, sudoku);
        return;
    }
    private boolean backtracking(char[][] board, int x, int y, Set<Character>[] sudoku){
        // System.out.println(x + " " + y);
        if(x > 8){
            // System.out.println("end");
            // for(Set<Character> set:sudoku){
            //     System.out.println(Arrays.toString(set.toArray()));
            // }
            return true;
        }
        if(board[x][y] == '.'){
            for(char i = '1'; i <= '9'; i++){
                if(checkIfAvailable(sudoku, x, y, i)){
                    // System.out.println(i);
                    board[x][y] = i;
                    int next_y = (y+1)%9;
                    int next_x = next_y == 0? (x+1):x;
                    if(backtracking(board, next_x, next_y, sudoku)){
                        return true;
                    }else{
                        sudoku[x].remove(i);
                        sudoku[y + 9].remove(i);
                        sudoku[18 + x/3*3 + y/3].remove(i);
                    }
                }

            }
            board[x][y] = '.';
        }else{
            int next_y = (y+1)%9;
            int next_x = next_y == 0? (x+1):x;
            if(backtracking(board, next_x, next_y, sudoku)){
                return true;
            }
        }
        return false;
    }

    private boolean checkIfAvailable(Set<Character>[] sudoku, int i, int j, char n){
        if(sudoku[i].contains(n) ||sudoku[9 + j].contains(n)
                        ||sudoku[18 + i/3*3 + j/3].contains(n)){
            // System.out.println(n);
            // System.out.println(sudoku[i].contains(n));
            // System.out.println(sudoku[9 + j].contains(n));
            // System.out.println(sudoku[18 + i/3*3 + j/3].contains(n));
            return false;
        }else{
            
            sudoku[i].add(n);
            sudoku[j + 9].add(n);
            sudoku[18 + i/3*3 + j/3].add(n);
            return true;
        }
    }
}

