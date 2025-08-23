import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;
    static int N, K;
    static int[] dist;    // 최단 시간 저장
    static int[] ways;    // 해당 위치에 도달하는 방법 수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        dist = new int[MAX + 1];
        ways = new int[MAX + 1];
        Arrays.fill(dist, -1); // 아직 방문하지 않은 곳은 -1

        bfs(N);

        System.out.println(dist[K]);  
        System.out.println(ways[K]); 
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;   // 시작 위치까지 시간 0
        ways[start] = 1;   // 시작 위치에 도달하는 방법은 1개

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next > MAX) continue;

                // 아직 방문하지 않은 경우
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;   // 최단 시간 갱신
                    ways[next] = ways[cur];      // 방법 수는 그대로 복사
                    queue.offer(next);
                }
                // 이미 방문했는데, 같은 최단 시간으로 도착하는 경우
                else if (dist[next] == dist[cur] + 1) {
                    ways[next] += ways[cur];     // 경우의 수 추가
                }
            }
        }
    }
}
