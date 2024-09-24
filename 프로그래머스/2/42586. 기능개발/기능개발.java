import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int days = (int)Math.ceil((double)remainingWork / speeds[i]);  
            q.offer(days);
        }
        
        while (!q.isEmpty()) {
            int currentDay = q.poll();
            int count = 1;
            
            while (!q.isEmpty() && q.peek() <= currentDay) {
                q.poll();
                count++;
            }
            
            result.add(count);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}
