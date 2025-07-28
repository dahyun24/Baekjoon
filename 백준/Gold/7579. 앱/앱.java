import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] cost = new int[N];
		int[] memory = new int[N];
		int[] dp = new int[10001];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int m = Integer.parseInt(st1.nextToken());
			int c = Integer.parseInt(st2.nextToken());
			memory[i] = m;
			cost[i] = c;
		}

		/**
		 * m의 합들이 M이 넘는 조합들 중에서 c의 합이 가장 작은 경우
		 */
		dp[0] = 0;
		// i번째 앱의 비활성 여부
		for (int i = 0; i < N; i++) {
			// 중복 선택을 막기 위해서 큰수부터 줄어듦
			for(int j = 10000; j >= cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
			}
		}
		for (int c = 0; c <= 10000; c++) {
			if (dp[c] >= M) {
				System.out.println(c);
				break;
			}
		}


	}

}
