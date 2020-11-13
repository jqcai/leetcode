import java.util.Stack;

/*
 * @lc app=leetcode id=772 lang=java
 *
 * [772] Basic Calculator III
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        // if(s.length() == 0){
        //     return 0;
        // }
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Character> stackSign = new Stack<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                continue;
            }
            // System.out.print(" " + ch);
            // System.out.print(stack.toString());
            // System.out.print(stackSign.toString());
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    stack.push(num);
                    num = 0;
                }
            } else if (ch == '(') {
                stackSign.push('(');
            } else if (ch == ')') {
                while (stackSign.peek() != '(') {
                    stack.push(operate(stackSign.pop(), stack.pop(), stack.pop()));
                }
                stackSign.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if(ch == '-'){
                    int j = i - 1;
                    while(j >= 0 && s.charAt(j) == ' '){
                        j--;
                    }
                    if(j < 0 || s.charAt(j) == '('){
                        stack.push(0);
                    }
                }
                while (!stackSign.isEmpty() && priority(stackSign.peek(), ch)) {
                    stack.push(operate(stackSign.pop(), stack.pop(), stack.pop()));
                }
                stackSign.push(ch);
            }
        }
        while(stackSign.size() > 0){
            stack.push(operate(stackSign.pop(), stack.pop(), stack.pop()));
        }
        
        return stack.peek();
    }
    private int operate(char ch, int b, int a){
        switch(ch){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
    private boolean priority(char op1, char op2){
        if(op1 == '(' || op1 == ')'){
            return false;
        }
        if(op2 == '*' || op2 == '/' &&(op1 == '+' || op1 == '-')){
            return false;
        }

        return true;
    }
}
// @lc code=end

