/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */
class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int n:nums){
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        int bucketSize = Math.max(1, (max - min) / (nums.length));
        int bucketNum = (max - min)/bucketSize + 1;
        int[][] buckets = new int[bucketNum][2];
        boolean[] occupied = new boolean[bucketNum];
        for(int i = 0; i < bucketNum; i++){
            buckets[i][0] = Integer.MAX_VALUE;
            buckets[i][1] = Integer.MIN_VALUE;
            occupied[i] = false;
        }
        for(int n:nums){
            int i = (n - min)/bucketSize;
            occupied[i] = true;
            buckets[i][0] = Math.min(n, buckets[i][0]);
            buckets[i][1] = Math.max(n, buckets[i][1]);
            
        }
        int prevBucketMax = min, maxGap = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (occupied[i] == false)
                continue;
            // System.out.println(Arrays.toString(buckets[i]));
            maxGap = Math.max(maxGap, buckets[i][0] - prevBucketMax);
            prevBucketMax = buckets[i][1];
        }

        return maxGap;
    }
}

