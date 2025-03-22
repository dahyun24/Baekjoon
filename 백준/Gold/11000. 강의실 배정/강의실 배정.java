import java.io.*;
import java.util.*;

public class Main {
	static class Lecture implements Comparable<Lecture> {
		int start, end;

		Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Lecture o) {
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Lecture[] lectures = new Lecture[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lectures[i] = new Lecture(s, e);
		}

		Arrays.sort(lectures); // 시작시간 기준 정렬

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lectures[0].end); // 첫 강의 종료시간 넣기

		for (int i = 1; i < N; i++) {
			// 가장 빨리 끝나는 강의와 비교
			if (lectures[i].start >= pq.peek()) {
				pq.poll(); // 기존 강의실 재사용
			}
			pq.offer(lectures[i].end); // 새 강의실 할당 or 갱신
		}

		System.out.println(pq.size()); // 필요한 강의실 수
	}
}
