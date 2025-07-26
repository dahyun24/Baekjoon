import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int a = Integer.parseInt(br.readLine());
			pq.offer(a);
		}
		combineFile(pq);
	}

	public static void combineFile(PriorityQueue<Integer> pq) {
		int total = 0;
		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			int c = a + b;
			total+= c;
			pq.offer(c);
		}
		System.out.println(total);
	}
}
