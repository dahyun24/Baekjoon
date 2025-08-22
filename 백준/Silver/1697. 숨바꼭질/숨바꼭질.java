import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] visited;

    static int second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈
        K = Integer.parseInt(st.nextToken()); // 동생

        visited = new boolean[100001];

        bfs(N);
        System.out.println(second);
    }

    // BFS 탐색
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == K) {
                    second = time;
                    return;
                }

                int[] moves = {cur - 1, cur + 1, cur * 2};
                for (int nx : moves) {
                    if (nx >= 0 && nx <= 100000 && !visited[nx]) {
                        visited[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            time++;
        }
    }

}
