import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 평균을 구할 과목 개수
		int n = Integer.parseInt(br.readLine());
		List<Integer> origin_score = new ArrayList<>();
		int max = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int score = Integer.parseInt(st.nextToken());
			// if (score > max) {
			// 	max = score;
			// }
			max = Math.max(max, score);
			origin_score.add(score);
		}
		float sum = 0;
		for (int i = 0; i < n; i++) {
			sum += ((float) origin_score.get(i)/max)*100;
		}
		System.out.println(sum/n);
	}
}