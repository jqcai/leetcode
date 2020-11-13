/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        if(haystack.length() == 0){
            return -1;
        }
        int[] kmp = new int[needle.length()];
        for (int i = 1; i < kmp.length; i++) {
            int count = 0;
            while (count + i < needle.length() && needle.charAt(count) == needle.charAt(i + count)) {
                kmp[count + i] = Math.max(kmp[count+i],++count);
            }
        }
        int len = 0;
        int start = 0;
        // out:while (start <= haystack.length() - needle.length()) {
        while (len < needle.length() && start + len < haystack.length()) {
            if (haystack.charAt(len + start) == needle.charAt(len)) {
                len++;
                if (len == needle.length()) {
                    return start;
                }
            } else {
                if(len == 0){
                    start ++;
                    // len = 0;
                    continue;
                }
                start = start + len - kmp[len - 1];
                len = kmp[len - 1];
            }
        }
        return -1;
    }
}
