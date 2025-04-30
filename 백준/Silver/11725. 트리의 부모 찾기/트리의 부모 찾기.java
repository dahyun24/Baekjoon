import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int[] parent = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : graph.get(current)) {
				if (!visited[next]) {
					parent[next] = current;
					visited[next] = true;
					queue.add(next);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append('\n');
		}
		System.out.print(sb);
	}
}
