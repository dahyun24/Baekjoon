import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/**
		 * 1
		 * 2-7 -> 6개
		 * 8-19 -> 12개
		 * 20-37 -> 18개
		 * 38-61 -> 24개
		 * 숫자의 규칙성 발견
		 */
		// 입력 받은 수가 어느 규칙에 들어가는 지 확인
		int N = Integer.parseInt(br.readLine());
		/**
		 * 1+6*1+6*2+6*3 ...
		 * 입력 받은 n이 어디 사이에 존재하는지,,
		 * 1+6*1+6*2+...+6*m < N < 1+6*1+6*2+...+6*(m+1) 일떄
		 * 답은 m+2
		 */
		if (N==1) {
			System.out.println("1");
		} else {
			int m = findM(N);
			System.out.println(m+2);
		}
	}
	public static int findM(int N) {
		for (int m = 0; ; m++) {
			int left = 3 * m * (m + 1) + 1;
			int right = 3 * (m + 1) * (m + 2) + 1;
			if (left <= N && N <= right) {
				return m;
			}
		}
	}
}
