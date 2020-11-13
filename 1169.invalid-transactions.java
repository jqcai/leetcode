import java.util.*;

/*
 * @lc app=leetcode id=1169 lang=java
 *
 * [1169] Invalid Transactions
 */
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new LinkedList<>();
        Map<String, Set<Trans>> hm = new HashMap<>();
        for (String transaction : transactions) {
            int i = 0;
        }
    }

    public class Trans {
        String name;
        int time;
        int amount;
        String city;
        String str;

        public Trans(String s) {
            String[] tmp = s.split(",");
            name = tmp[0];
            time = Integer.parseInt(tmp[1]);
            amount = Integer.parseInt(tmp[2]);
            city = tmp[3];
            str = s;
        }

        @Override
        public int hashCode() {
            return str.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Trans)) {
                return false;
            }
            Trans tr = (Trans) obj;
            return str == tr.str;
        }

    }
}
