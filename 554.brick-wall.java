/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0 || wall.get(0).size() == 0){
            return 0;
        }
        int sum = 0;
        for(int w:wall.get(0)){
            sum += w;
        }
        int[] bricks = new int[sum - 1];
        Arrays.fill(bricks, wall.size());
        for(List<Integer> ls:wall){
            int pre = 0;
            for(int w:ls){
                pre += w;
                if(pre < sum && pre > 0){
                    bricks[pre - 1]--;
                } 
            }
        }
        int min = Integer.MAX_VALUE;
        for(int b:bricks){
            min = Math.min(b, min);
        }
        return min == Integer.MAX_VALUE? wall.size():min;
    }
}

