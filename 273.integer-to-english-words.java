/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */
class Solution {
    public String numberToWords(int num) {
        String[] top20 = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen" };
        String[] top100 = new String[] { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        String[] bigValue = new String[] { "Thousand", "Million", "Billion" };
        if (num < 20) {
            return top20[num];
        }
        if (num < 100) {
            return top100[num / 10 - 2] + (num % 10 == 0 ? "" : (' ' + top20[num % 10]));
        }
        if (num < 1000) {
            String tmp = numberToWords(num % 100);
            String ans = top20[num/100] + " Hundred";
            if(tmp != "Zero"){
                ans += ' ' + tmp;
            }
            return ans;
        }
        if(num < 1000000){
            String tmp = numberToWords(num%1000);
            String ans = numberToWords(num/1000) + ' ' + bigValue[0];
            if(tmp != "Zero"){
                ans += ' ' + tmp;
            }
            return ans;
        }
        if(num < 1000000000){
            String tmp = numberToWords(num%1000000);
            String ans = numberToWords(num/1000000) + ' ' + bigValue[1];
            if(tmp != "Zero"){
                ans += ' ' + tmp;
            }
            return ans;
        }
        String tmp = numberToWords(num%1000000000);
        String ans = numberToWords(num/1000000000) + ' ' + bigValue[2];
        if(tmp != "Zero"){
            ans += ' ' + tmp;
        }
        return ans;
    }
}
