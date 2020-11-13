import java.util.*;
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for(char ch:s.toCharArray()){
            if(ch == '('){
                left ++;
            }else if(ch == ')'){
                if(left == 0){
                    right ++;
                }else{
                    left --;
                }
            }
        }
        Set<String> ans = new HashSet<>();
        bfs(ans, s, 0, 0, 0, left, right, new StringBuffer());
        // System.out.println(ans.toString());
        return new LinkedList<String>(ans);
        
    }
    
    private void bfs(Set<String> ans, String s, int pos, int left, int right, 
                     int leftRm, int rightRm, StringBuffer sb){
        // System.out.println(left + " " + right + " " + leftRm + " " + rightRm + " " + pos);
        if(leftRm == 0 && rightRm == 0 && pos == s.length()){
            ans.add(sb.toString());
            return;
        }else if(pos == s.length()){
            return;
        }
        if(s.charAt(pos) == '(' && leftRm > 0){
            bfs(ans, s, pos + 1, left, right, leftRm - 1, rightRm, sb);
        }else if(s.charAt(pos) == ')' && rightRm > 0){
            bfs(ans, s, pos + 1, left, right, leftRm, rightRm - 1, sb);
        }
        sb.append(s.charAt(pos));
        if(s.charAt(pos) != '(' && s.charAt(pos) != ')'){
            bfs(ans, s, pos + 1, left, right, leftRm, rightRm, sb);
        }else if(s.charAt(pos) == '('){
            bfs(ans, s, pos + 1, left + 1, right, leftRm, rightRm, sb);
        }else if(s.charAt(pos) == ')' && left > right){
            bfs(ans, s, pos + 1, left, right + 1, leftRm, rightRm, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        return;
    }
}