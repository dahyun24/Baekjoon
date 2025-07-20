import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int k;

	private final static int NUM = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int answer = factorial(n) / (factorial(k)*factorial(n-k));

		System.out.println(answer);
	}

	public static int factorial(int n) {
		if(n == 0) return 1;
		return n * factorial(n-1);
	}
}
