class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int count =0;
        visited = new boolean[n];
        for (int i=0; i< n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                count++;
            }
        }
        return count;
    }
    
    static void dfs(int i, int[][] computers) {
        visited[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (computers[i][j] == 1 && !visited[j]) {
                dfs(j, computers);
            }
        }
        
    }
}