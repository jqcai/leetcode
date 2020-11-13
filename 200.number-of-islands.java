import javafx.util.Pair;
import java.util.*;
/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count ++;
                    queue.add(new Pair(i, j));
                    while(queue.size() > 0){
                        int tmpI = queue.peek().getKey();
                        int tmpJ = queue.poll().getValue();
                        if(tmpI>=grid.length || tmpI < 0 || tmpJ >= grid[0].length|| tmpJ < 0){
                            continue;
                        }else if(grid[tmpI][tmpJ] == '0'){
                            continue;
                        }
                        grid[tmpI][tmpJ] = '0';
                        for(int[] dir:dirs){
                            queue.add(new Pair(tmpI + dir[0], tmpJ + dir[1]));
                        }
                    }
                }
            }
        }
        return count;
    }
}

