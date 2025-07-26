import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger[] fib = new BigInteger[n+1];
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;

		for (int i = 2; i <= n; i++) {
			BigInteger temp = a.add(b);
			a = b;
			b = temp;
		}

		System.out.println(n == 0 ? a : b);
	}
}
