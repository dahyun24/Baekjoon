import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int count = 0;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); // 방향 0,1,2,3

		// 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// cur 를 시작으로 청소 시작
		cleanRoom(r,c,d);
		System.out.println(count);
	}

	static void cleanRoom(int r, int c, int d) {
		if (map[r][c] == 0) {
			map[r][c] = 2;
			count++;
		}

		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int x = r + dx[d];
			int y = c + dy[d];
			if (map[x][y] == 0) {
				cleanRoom(x, y, d);
				return;
			}
		}

		// for 문을 나왔다 = 네 방향 모두 청소되었거나 벽
		int back = (d + 2) % 4;
		int bx = r + dx[back];
		int by = c + dy[back];

		if (map[bx][by] != 1) {
			cleanRoom(bx, by, d);
		}
	}
}
