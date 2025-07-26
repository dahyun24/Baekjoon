import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
        // 피보나치 수는 직전 2개 값만 알면 다음 값을 계산할 수 있기 때문에 배열이 없어도 된다.
		for (int i = 2; i <= n; i++) {
			BigInteger temp = a.add(b);
			a = b;
			b = temp;
		}

		System.out.println(n == 0 ? a : b);
	}
}
