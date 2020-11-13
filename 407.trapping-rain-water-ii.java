import java.util.*;
/*
 * @lc app=leetcode id=407 lang=java
 *
 * [407] Trapping Rain Water II
 */
class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length < 3 || heightMap[0].length < 3){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new PriorityQueue<>(m * n, new Comparator<Integer>(){
            public int compare(Integer a, Iteger b){
                return heightMap[a / 110][a % 110] - heightMap[b / 110][b % 110];
            }
        });
    }
}

