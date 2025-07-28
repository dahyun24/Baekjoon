import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		final int INF = 1_000_000_000;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 버스의 개수
		int[][] city = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) city[i][j] = 0;
				else city[i][j] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			city[a][b] = Math.min(city[a][b], c);
		}

		for (int k = 1; k <= n; k++) {     // 중간에 거치는 도시
			for (int i = 1; i <= n; i++) { // 출발 도시
				for (int j = 1; j <= n; j++) { // 도착 도시
					if (city[i][k] != INF && city[k][j] != INF) {
						city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (city[i][j] == INF) System.out.print("0 ");
				else System.out.print(city[i][j] + " ");
			}
			System.out.println();
		}
	}
}
