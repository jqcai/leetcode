/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int total = 0;
        int val = 0;
        int multi = 0;
        // st.push(1);
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                val = val * 10 + (c - '0');
            } else if(c == '+' || c == '-' ||c =='*'||c == '/'){
                if (multi != 0) {
                    // System.out.println(12345);
                    // System.out.println(sign);
                    val = (multi == 1 ? total * val : total / val);
                    // System.out.println(total);
                    multi = 0;
                }
                if (sign != 0) {
                    st.push(total);
                    st.push(sign);
                    sign = 0;
                }
                switch (c) {
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                case '*':
                    multi = 1;
                    break;
                case '/':
                    multi = -1;
                    break;
                }
                total = val;
                val = 0;
            }
        }
        // System.out.println(val);
        // System.out.println(total);
        if(sign != 0){
            st.push(total);
            st.push(sign);
        }
        if(multi == 1){
            total = total * val;
            val = total;
        }
        if(multi == -1){
            total = total / val;
            val = total;
        }
        total = 0;
        // System.out.println(st.toString());
        // System.out.println(val);
        while(st.size() > 1){
            total += val * st.pop();
            val = st.pop();
        }
        total += val;
        return total;
    }
}
