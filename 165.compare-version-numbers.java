/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        int swap = 1;
        if (array2.length > array1.length) {
            swap = -1;
            String[] tmp = array1;
            array1 = array2;
            array2 = tmp;
        }
        int i = 0;
        for (i = 0; i < array2.length; i++) {
            int a = Integer.parseInt(array1[i]);
            int b = Integer.parseInt(array2[i]);
            if(a > b){
                return swap * 1;
            }else if(a < b){
                return -1 * swap;
            }
        }
        for(; i < array1.length; i++){
            if(Integer.parseInt(array1[i]) > 0){
                return swap * 1;
            }
        }
        return 0;
    }
}
