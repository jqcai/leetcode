import java.util.*;

/*
 * @lc app=leetcode id=957 lang=java
 *
 * [957] Prison Cells After N Days
 */
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, String> hm = new HashMap<>();
        Map<String, Integer> reverse = new HashMap<>();
        hm.put(0, Arrays.toString(cells));
        reverse.put(Arrays.toString(cells), 0);
        for(int i = 1; i <= N; i ++){
            cells = update(cells);
            String tmp = Arrays.toString(cells);
            if(reverse.containsKey(tmp)){
                int prePos = reverse.get(tmp);
                String fin = hm.get((N - i) % (i - prePos) + prePos);
                // System.out.println(hm.toString());
                return toIntArray(fin);
            }
            reverse.put(tmp, i);
            hm.put(i, tmp);
        }
        return cells;
    }
    public int[] update(int [] cells){
        if(cells.length == 0){
            return cells;
        }
        int pre = cells[cells.length - 1];
        for(int i = cells.length - 1; i > 0; i--){
            int tmp = pre;
            pre = cells[i];
            cells[i] = 1 ^ (cells[i - 1] ^ tmp);
        }
        cells[0] = 0;
        cells[cells.length - 1] = 0;
        return cells;
    }
    public static int[] toIntArray(String input) {
        String beforeSplit = input.replaceAll("\\[|\\]|\\s", "");
        String[] split = beforeSplit.split("\\,");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }
}

