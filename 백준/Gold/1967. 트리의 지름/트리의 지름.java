import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int to, weight;
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static List<Node>[] tree;
	static boolean[] visited;
	static int maxDistance = 0;
	static int farthestNode = 0;
	static void dfs(int current, int distance) {
		if (distance > maxDistance) {
			maxDistance = distance;
			farthestNode = current;
		}

		for (Node next : tree[current]) {
			if (!visited[next.to]) {
				visited[next.to] = true;
				dfs(next.to, distance + next.weight);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            System.out.println(0);
            return;
        }
		
        tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree[from].add(new Node(to, weight));
			tree[to].add(new Node(from, weight));
		}

		// 1차 DFS
		visited = new boolean[N + 1];
		visited[1] = true;
		dfs(1, 0);

		// 2차 DFS
		visited = new boolean[N + 1];
		visited[farthestNode] = true;
		maxDistance = 0;
		dfs(farthestNode, 0);

		System.out.println(maxDistance);  // 트리의 지름
	}
}