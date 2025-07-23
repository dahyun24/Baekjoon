import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private final static int MOD = 1000;
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}

		int[][] result = power(b);

		// 결과 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	// 분할 정복
	public static int[][] power(long b) {
		if (b==1) return arr;

		int [][] half = power(b/2);
		int [][] temp = multiply(half, half);

		if (b % 2 == 1) {
			temp = multiply(temp, arr);
		}
		return temp;
	}

	public static int[][] multiply(int[][] a, int[][] b) {
		int[][] res = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = 0;
				for (int k = 0; k < n; k++) {
					sum += (a[i][k] * b[k][j]) % MOD;
				}
				res[i][j] = sum % MOD;
			}
		}
		return res;
	}
}
