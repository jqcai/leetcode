/*
 * @lc app=leetcode id=158 lang=java
 *
 * [158] Read N Characters Given Read4 II - Call multiple times
 */
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    // int res = 0;
    StringBuffer pre = new StringBuffer();
    public int read(char[] buf, int n) {
        if(n <= pre.length()){
            for(int i = 0; i < n; i++){
                buf[i] = pre.charAt(0);
                pre.deleteCharAt(0);
            }
            return n;
        }
        int rd = 0;
        while(pre.length() < n){
            rd = read4(buf);
            for(int i = 0; i < rd; i++){
                pre.append(buf[i]);
            }
            if(rd < 4){
                break;
            }
        }
        // System.out.print(pre.toString());
        int ans = 0;
        int len = pre.length();
        for(int i = 0; i < Math.min(n, len); i++){
            buf[i] = pre.charAt(0);
            pre.deleteCharAt(0);
            ans++;
        }
        return ans;
    }
}

