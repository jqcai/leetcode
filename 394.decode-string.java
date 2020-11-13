import java.util.*;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */
class Solution {
    public String decodeString(String s) {
        Stack<Integer> stI = new Stack<>();
        Stack<StringBuffer> stS = new Stack<>();
        int num = 0;
        StringBuffer sb = new StringBuffer();
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stI.push(num);
                stS.push(sb);
                sb = new StringBuffer();
                num = 0;
            } else if (ch == ']') {
                StringBuffer sb_tmp = stS.pop();
                for (int j = stI.pop(); j > 0; j--) {
                    sb_tmp.append(sb);
                }
                sb = sb_tmp;
            } else if (Character.isLetter(ch)) {
                sb.append(ch);
            } else {
                num = num * 10 + ch - '0';
            }
        }
        return sb.toString();
    }
}
