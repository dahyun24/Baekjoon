import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n+1];
		dp = new int[n+1][n+1];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			p[i+1] = Integer.parseInt(st.nextToken());
		}

		// 구간 길이 2부터 K까지
		for (int len = 2; len <= n; len++) {
			for (int i = 1; i <= n - len + 1; i++) {
				int j = i + len - 1;
				dp[i][j] = Integer.MAX_VALUE;
				// 중간 분할 위치 k
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k + 1][j] + p[i-1]*p[k]*p[j]);
				}
			}
		}
		System.out.println(dp[1][n]);
	}
}
