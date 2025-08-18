import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        // 초기화
        Arrays.fill(visited, false);
        bfs(V);
    }

    // queue
    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+" ");
            for(int i = 1; i <= N; i++){
                if(graph[u][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    // stack 혹은 재귀
    static void dfs(int v){
        visited[v] = true;
        System.out.print(v+" ");
        for(int i = 1; i <= N; i++){
            if(graph[v][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
