import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int MOD = 1_000_000;
	static final int PISANO = 1_500_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		// P(주기의 길이)=15*10^(k-1)
		// M(나누는 수)=10^k (k>2)
		// M은 1000000 = 10^6 => k=6 따라서 주기의 길이 P는 15*10^5 이다.
		n %= PISANO;
		long[] fib = new long[PISANO];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i <= n; i++) {
			fib[i] = (fib[i-1] + fib[i-2]) % MOD;
		}

		System.out.println(fib[(int)n]);
	}
}
