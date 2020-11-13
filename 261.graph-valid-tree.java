// import java.util.*;

/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind union = new UnionFind(n);
        for(int[] edge:edges){
            // System.out.println(Arrays.toString(edge));
            if(union.union(edge[0], edge[1])){
                return false;
            }
        }
        for(int i = 1; i < n; i++){
            if(union.find(i)!=union.find(i - 1)){
                return false;
            }
        }
        return true;
    }



    class UnionFind{
        int[] uf;
        // int[] size;
        public UnionFind(int n){
            uf = new int[n];
            for(int i = 0; i < uf.length; i++){
                uf[i] = i;
            }
            // size = new int[n];
        }
        public int find(int x){
            if(uf[x] != x){
                uf[x] = find(uf[x]);
            }
            return uf[x];
        }
        public boolean union(int x, int y){
            int fx = find(x), fy = find(y);
            if(fx != fy){
                // size[fx] += size[fy];
                uf[fy] = fx;
            }else{
                return true;
            }
            return false;
        }
        // public int getSize(int x){
        //     return size[find(x)];
        // }

    }
}

