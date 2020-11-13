import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        backtracking(ans, tmp, 0, 1, k, n);
        return ans;
    }
    private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int tmpSum,int min, int k, int n){
        // System.out.println(Arrays.toString(tmp.toArray()));
        // System.out.println(tmpSum);
        if(tmp.size() == k && tmpSum == n){
            ans.add(new ArrayList<Integer>(tmp));
            return;
        }else if(tmp.size() >= k || tmpSum >= n){
            return;
        }
        for(int i = min; i < 10; i++){
            tmp.add(i);
            backtracking(ans, tmp, tmpSum + i, i + 1, k, n);
            tmp.remove(tmp.size() - 1);
        }


    }
}

