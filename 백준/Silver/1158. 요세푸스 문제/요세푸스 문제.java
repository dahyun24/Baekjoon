import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("<");
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			q.add(i+1);
		}
		while (q.size() > 1) {
			for (int i = 1; i < k; i++) {
				int a = q.remove();
				q.add(a);
			}
			int b = q.remove();
			bw.write(b + ", ");
		}
		bw.write(q.peek()+">");
		bw.flush();
		bw.close();
	}
}