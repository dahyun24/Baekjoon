import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private final static int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		// 이항 계수 = n! / k! (n-k)!
		long num = factorial(n);

		long denom = factorial(k) * factorial(n - k) % MOD;

		// 페르마의 소정리 : 모듈러에서 나눗셈을 할 수 없기에,, 역원이라는 개념이 필요하다.
		System.out.println(num * pow(denom, MOD-2) % MOD);


	}

	public static long factorial(long n) {
		long fac = 1L;

		while (n > 1) {
			fac = (fac * n) % MOD;
			n--;
		}
		return fac;
	}

	public static long pow(long base, long exp) {
		if (exp == 1) {
			return base % MOD;
		}

		long temp = pow(base, exp / 2);

		/**
		 * 현재 지수가 홀수이면
		 * base^(exp/2) * base^(exp/2) * base 이므로
		 * base를 한번 더 곱해주어야한다.
		 *
		 * ex) A^9 = A^4 * A^4 * A
		 */
		if (exp % 2 == 1) {
			return (temp * temp % MOD) * base % MOD;
		}
		return temp * temp % MOD;
	}
}
