import java.util.*;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */
class Solution {
    public String simplifyPath(String path) {
        String[] splt = path.split("/");
        // System.out.println(Arrays.toString(splt));
        StringBuilder ans = new StringBuilder();
        Stack<String> st = new Stack<>();
        for(String s:splt){
            if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else if(s.equals(".")){
                continue;
            }else if(!s.equals("")){
                st.push(s);
            }
        }
        while(!st.isEmpty()){
            ans.insert(0, st.pop());
            ans.insert(0, "/");
        }
        if(ans.length()==0){
            ans.append('/');
        }
        return ans.toString();
    }
}

