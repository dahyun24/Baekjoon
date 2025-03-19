import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }

        Set<Integer> set = new HashSet<>(answer);
        answer = new ArrayList<>(set);
        
        Collections.sort(answer);
        
        return answer;
    }
}
