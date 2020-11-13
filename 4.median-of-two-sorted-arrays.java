/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int midSize = (nums1.length + nums2.length) / 2;
        int start = 0, end = nums1.length;
        int mid = 0;
        int rest = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            rest = midSize - mid;
            if (mid > 0 && rest < nums2.length && nums1[mid - 1] > nums2[rest]) {
                end = mid - 1;
            } else if (rest > 0 && mid < nums1.length && nums2[rest - 1] > nums1[mid]) {
                start = mid + 1;
            } else {
                break;
            }
        }
        // System.out.println(mid);
        // System.out.println(rest);
        int right = Math.min(mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE,
                rest < nums2.length ? nums2[rest] : Integer.MAX_VALUE);
        int left = Math.max(mid <= 0 ? Integer.MIN_VALUE : nums1[mid - 1],
                rest <= 0 ? Integer.MIN_VALUE : nums2[rest - 1]);
        if ((nums1.length + nums2.length) % 2 == 1) {
            return right;
        } else {
            return (left + right) / 2.0;
        }

    }
}
