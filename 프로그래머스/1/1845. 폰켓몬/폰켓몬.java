import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        int max = N/2;
        int a = map.keySet().size();
        if (a >= max) return max;
        else return a;
    }
}