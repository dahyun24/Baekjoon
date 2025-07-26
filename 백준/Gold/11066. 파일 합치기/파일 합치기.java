import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] files = new int[N+1];
			dp = new int[N+1][N+1];
			sum = new int[N+1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				files[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1] + files[j];
			}

			// 구간 길이 2부터 K까지
			for (int len = 2; len <= N; len++) {
				for (int i = 1; i <= N - len + 1; i++) {
					int j = i + len - 1;
					dp[i][j] = Integer.MAX_VALUE;
					// 중간 분할 위치 k
					for (int k = i; k < j; k++) {
						dp[i][j] = Math.min(dp[i][j],
							dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
					}
				}
			}
			System.out.println(dp[1][N]);
		}
	}
}
