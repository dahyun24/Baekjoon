import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int M;
	static int[][] map;
	static final List<Point> virus = new ArrayList<>();
	static int max;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new Point(i,j));
				}
			}
		}
		// 무작위로 3개의 벽을 세운 후 바이러스 퍼뜨려서 안전 영역의 개수 세기
		int count = 0;
		buildWall(count);
		System.out.println(max);
	}

	// DFS 방식으로 일일이 벽 세우기
	private static void buildWall(int count) {
		if (count == 3){
			spreadVirus();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++){
				if (map[i][j] == 0) {
					map[i][j] = 1; // 벽 세우기
					buildWall(count + 1);
					map[i][j] = 0; // 되돌리기
				}
			}
		}
	}

	// 바이러스 퍼뜨리기
	private static void spreadVirus() {
		int[][] temp = copyMap(map);
		// 큐에 바이러스의 위치 넣기
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			queue.offer(virus.get(i));
		}
		// 2 위치를 시작으로 주위에 0이 있으면 2로 만들기
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = point.x + dx[i];
				int newY = point.y + dy[i];
				if (newX >= 0 && newX < N && newY >= 0 && newY < M && temp[newX][newY] == 0) {
					temp[newX][newY] = 2;
					queue.offer(new Point(newX, newY));
				}
			}

		}
		updateMaxSafeZone(temp);
	}

	// 안전 영역 개수 세기
	private static void updateMaxSafeZone(int[][] temp) {
		int count = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (temp[i][j] == 0) count++;

		max = Math.max(max, count);
	}

	private static int[][] copyMap(int[][] original) {
		int[][] copy = new int[original.length][original[0].length];
		for (int i = 0; i < original.length; i++) {
			copy[i] = original[i].clone();
		}
		return copy;
	}
}