import java.util.*;
/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */
class Solution {
    public int calculate(String s) {
        Stack<Integer> preValue = new Stack<>();
        int total = 0;
        int val = 0;
        int sign = 1;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                val*=10;
                val += (ch -'0');
            }else if(ch == '+'){
                total += val*sign;
                val = 0;
                sign = 1;
            }else if(ch == '-'){
                total += val * sign;
                val = 0;
                sign = -1;
            }else if(ch == '('){
                preValue.push(total);
                preValue.push(sign);
                sign = 1;
                total = 0;
            }else if(ch == ')'){
                total += sign * val;
                total = preValue.pop() * total + preValue.pop();
                val = 0;
                sign = 1;
            }
        }
        if(val != 0){
            total += sign * val;
        }
        return total;
    }
}

