import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
	static final List<Point> chickens = new ArrayList<>();
	static final List<Point> houses = new ArrayList<>();
	static final List<Point> selectedChickens = new ArrayList<>();
	static int minTotalDistance = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		// 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chickens.add(new Point(i,j));
				} else if (map[i][j] == 1) {
					houses.add(new Point(i,j));
				}
			}
		}
		// 무작위로 치킨집 M개 선택
		combination(0,0);
		System.out.println(minTotalDistance);
	}

	static void combination(int start, int depth) {
		if (depth == M) {
			calculateChickendistance();
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			selectedChickens.add(chickens.get(i));
			combination(i + 1, depth + 1);
			selectedChickens.remove(selectedChickens.size() - 1);
		}
	}

	static void calculateChickendistance() {
		int sum_distance = 0;
		for (int i = 0; i < houses.size() ; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < selectedChickens.size(); j++) {
				min = Math.min(min, distance(houses.get(i), selectedChickens.get(j)));
			}
			sum_distance += min;
		}
		minTotalDistance = Math.min(minTotalDistance, sum_distance);
	}

	static int distance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}
