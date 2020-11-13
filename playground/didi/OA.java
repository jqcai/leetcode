package playground.didi;

import java.util.*;

class OA {
    public static int maxFive(int N) {
        Stack<Integer> st = new Stack<>();
        boolean negative = N < 0;
        N = Math.abs(N);
        st.push(N % 10);
        N = N / 10;
        while (N > 0) {
            st.push(N % 10);
            N = N / 10;
        }
        int ans = 0;
        while (st.size() >= 0) {
            if (st.size() == 0 || st.peek() < 5) {
                ans = ans * 10 + 5;
                break;
            } else {
                ans = ans * 10 + st.pop();
            }
        }
        while (st.size() > 0) {
            ans = ans * 10 + st.pop();
        }
        return negative ? -ans : ans;

    }

    public static int[] wrong(int N) {
        int[] ans = new int[N];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }

    // public int longestConcaten(String[] list) {
        
    // }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(wrong(4)));
    }
}