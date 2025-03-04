import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			String word = st.nextToken();
            // 문자열 추가, 삭제, 반복에 자주 쓰이는 CLASS
			StringBuilder sb = new StringBuilder();
			for (char c : word.toCharArray()) {
				for (int j = 0; j < m; j++) {
					sb.append(c);
				}
			}
			System.out.println(sb);

		}
	}
}
