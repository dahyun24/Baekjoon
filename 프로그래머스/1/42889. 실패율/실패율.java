import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] failed = new int[N + 2]; 
        int[] reached = new int[N + 1]; 

        for (int stage : stages) {
            failed[stage]++; 
        }

        reached[N] = failed[N] + failed[N + 1];
        for (int i = N - 1; i >= 1; i--) {
            reached[i] = reached[i + 1] + failed[i];
        }

        HashMap<Integer, Double> failRate = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (reached[i] == 0) {
                failRate.put(i, 0.0);
            } else {
                failRate.put(i, (double) failed[i] / reached[i]);
            }
        }
        
        return failRate.entrySet().stream().sorted((o1,o2)->Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}
