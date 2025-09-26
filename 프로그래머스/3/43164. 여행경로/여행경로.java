import java.util.*;

class Solution {
    static List<String> answer;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", tickets, path, 0);
        
        return answer.toArray(new String[0]);
    }
    
    static boolean dfs(String cur, String[][] tickets, List<String> path, int used) {
        if (used == tickets.length) {
            answer = new ArrayList<>(path);
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)){
                visited[i] = true;
                path.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], tickets, path, used +1)) return true;
                
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
        
        return false;
    }
}