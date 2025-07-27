import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] dist;
	static int min = Integer.MAX_VALUE;
	static int w, h;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;

			map = new char[h][w];
			List<Point> points = new ArrayList<>();

			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == 'o') {
						points.add(0,new Point(i, j)); // 시작점은 맨 앞
					} else if (map[i][j] == '*') {
						points.add(new Point(i, j));
					}
				}
			}

			int k = points.size();
			// dist 2차원 배열은 i 포인트에서부터 j포인트 까지의 최소 거리를 저장
			dist = new int[k][k];

			// 모든 포인트 간 거리 계산
			boolean impossible = false;
			for (int i = 0; i < k; i++) {
				int[][] bfsResult = bfs(points.get(i)); // i포인트 부터 각 포인트까지의 거리를 저장
				for (int j = 0; j < k; j++) {
					Point target = points.get(j);
					dist[i][j] = bfsResult[target.x][target.y]; // bfsResult에 target의 x,y 좌표를 넣으면 i부터 해당 target까지의 최소 거리를 저장
					if (dist[i][j] == -1) impossible = true;
				}
			}

			if (impossible) {
				System.out.println(-1);
				continue;
			}

			// 1 ~ k-1까지 순열 생성 (0은 시작점)
			min = Integer.MAX_VALUE;
			boolean[] visited = new boolean[k];
			visited[0] = true;
			// dist에서 더러운 칸을 닦는 최소 거리 합을 찾아야함
			dfs(0, 0, 1, visited, k); // 현재 위치, 누적 거리, 방문 수, visited 배열, 총 포인트 수
			System.out.println(min);
		}
	}

	/**
	 * 시작점(0)에서 출발해서
	 * points[1] ~ points[k-1]까지 모든 더러운 칸을 한 번씩 방문하는 모든 경로를 확인
	 * 각 경로의 거리합을 계산해서 최소 거리(min) 갱신
	 * @param curr : 지금 현재 위치한 포인트 번호 (points의 인덱스)
	 * @param total : 지금까지 누적된 거리 합
	 * @param count : 지금까지 방문한 포인트 수
	 * @param visited : 어떤 포인트를 방문했는지 여부
	 * @param k : 전체 포인트 개수 (시작점 + 더러운 칸들)
	 */
	static void dfs(int curr, int total, int count, boolean[] visited, int k) {
		if (count == k) {
			min = Math.min(min, total);
			return;
		}

		for (int i = 1; i < k; i++) {
			if (!visited[i] && dist[curr][i] != -1) {
				visited[i] = true;
				dfs(i, total + dist[curr][i], count + 1, visited, k);
				visited[i] = false;
			}
		}
	}

	static int[][] bfs(Point start) {
		int[][] visited = new int[h][w];
		for (int[] row : visited) Arrays.fill(row, -1);

		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		visited[start.x][start.y] = 0;

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
				if (map[nx][ny] == 'x' || visited[nx][ny] != -1) continue;

				visited[nx][ny] = visited[p.x][p.y] + 1;
				q.offer(new Point(nx, ny));
			}
		}
		return visited;
	}
}
