/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean flag_e = false;
        // boolean sign_num = false;
        // boolean sign_e = false;
        boolean deci = false;
        boolean digit = false;
        if(s.length() == 0){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '.'){
                if(s.length() == 1){
                    return false;
                }
                else if(flag_e||deci){
                    return false;
                // }else if(i!=0 && !Character.isDigit(s.charAt(i - 1))){
                    // return false;
                }else{
                    deci = true;
                }
            }
            else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i != 0 && s.charAt(i - 1) != 'e'){
                    return false;
                }else if(i == s.length() - 1){
                    return false;
                }
            }
            else if(s.charAt(i) =='e'){
                if(i == s.length() - 1 || i == 0 || flag_e){
                    return false;
                }else if(!digit){
                    return false;
                }else{
                    flag_e = true;
                }
            }
            else if(!Character.isDigit(s.charAt(i))){
                return false;
            }else{
                digit = true;
            }
        }
        return digit;
    }
}

