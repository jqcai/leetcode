import java.util.*;
/*
 * @lc app=leetcode id=682 lang=java
 *
 * [682] Baseball Game
 */
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for(String op:ops){
            if(op.equals("C")){
                if(st.size()>0){
                    st.pop();
                }
            }else if(op.equals("+")){
                int tmp = st.pop();
                int tmp2 = st.peek() + tmp;
                st.push(tmp);
                st.push(tmp2);
            }else if(op.equals("D")){
                st.push(st.peek() * 2);
            }else{
                st.push(Integer.parseInt(op));
            }
        }
        int ans = 0;
        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
}

