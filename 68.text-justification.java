import java.util.*;
/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> buffer = new LinkedList<>();
        int len = 0;
        List<String> ans = new LinkedList<>();
        for(String s:words){
            if(len + s.length() + buffer.size() <= maxWidth){
                buffer.add(s);
                len += s.length();
            }else{
                // System.out.println(Arrays.toString(buffer.toArray()));
                StringBuffer sb = new StringBuffer();
                if(buffer.size() == 1){
                    buffer.add("");
                }
                int space = maxWidth - len;
                int si = buffer.size();
                for(int i = 0; i < si; i++){
                    sb.append(buffer.remove(0));
                    if(buffer.size() > 0){
                        int j = 0;
                        for(; j < ((space - 1)/ buffer.size() + 1); j++){
                            sb.append(' ');
                        }
                        space -= j;
                    }
                }
                ans.add(sb.toString());
                sb = new StringBuffer();
                buffer.clear();
                buffer.add(s);
                len = s.length();
            }
        }
        if(buffer.size() > 0){
            StringBuffer sb = new StringBuffer();
            // System.out.println(Arrays.toString(buffer.toArray()));
            for(int i = 0; i < buffer.size(); i++){
                sb.append(buffer.get(i));
                if(i != buffer.size() - 1){
                    sb.append(' ');
                }
            }
            while(sb.length() < maxWidth){
                sb.append(' ');
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}

