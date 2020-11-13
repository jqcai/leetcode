/*
 * @lc app=leetcode id=959 lang=java
 *
 * [959] Regions Cut By Slashes
 */
class Solution {
    public int regionsBySlashes(String[] grid) {
        if(grid.length == 0){
            return 0;
        }
        int n = grid.length;
        UF uf = new UF(grid.length * grid.length * 4);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i].charAt(j) == ' '){
                    
                }
            }
        }
        return 0;
    }

    public class UF{
        int[] parent;
        public UF(int n){
            parent = new int[n];
            for(int i = 0; i < parent.length; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int union(int x, int y){
            int fx = find(x);
            int fy = find(y);
            if(fx != fy){
                parent[fx] = fy;
            }
            return fy;
        }
    }
}

