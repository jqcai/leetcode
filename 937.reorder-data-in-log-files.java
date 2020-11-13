import java.util.*;
/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>(){
            public int compare(String a, String b){
                String a_id = a.split(" ")[0];
                String b_id = b.split(" ")[0];
                String a_content = a.substring(a_id.length() + 1);
                String b_content = b.substring(b_id.length() + 1);
                boolean a_num = Character.isDigit(a_content.charAt(0));
                boolean b_num = Character.isDigit(b_content.charAt(0));
                if (!a_num && !b_num) {
                    int cmp = a_content.compareTo(b_content);
                    if (cmp != 0) return cmp;
                    return a_id.compareTo(b_id);
                }
                return a_num ? (b_num ? 0 : 1) : -1;
            }
        });
        return logs;
    }
}

