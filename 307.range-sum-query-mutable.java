/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */
class NumArray {
    int[] segmentTree;
    int size;

    public NumArray(int[] nums) {
        size = nums.length;
        if (size > 0) {
            segmentTree = new int[size * 2];
        }
        for (int i = 0; i < size; i++) {
            segmentTree[i + size] = nums[i];
        }
        for (int i = size - 1; i >= 0; i--) {
            segmentTree[i] = segmentTree[i * 2] + segmentTree[i * 2 + 1];
        }
    }

    public void update(int i, int val) {
        if (i < 0 || i >= size) {
            return;
        }
        i += size;
        int dif = val - segmentTree[i];
        while(i > 0){
            segmentTree[i] += dif;
            i /= 2;
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || i >= size) {
            throw (new Error("index out of range"));
        }
        int sum = 0;
        i += size;
        j += size;
        while (i <= j) {
            
            if (i % 2 == 1) {
                sum += segmentTree[i];
                i++;
            }
            if (j % 2 == 0) {
                sum += segmentTree[j];
                j--;
            }
            i = i / 2;
            j = j / 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(i,val); int param_2 = obj.sumRange(i,j);
 */
