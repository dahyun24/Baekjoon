import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> tree = new ArrayList<>();
	static boolean[] visited;
	static int root = 0;
	static int count = 0;

	public static void count_leaf(int root) {
		List<Integer> children = tree.get(root);

		// 자식이 없는 경우 = 리프 노드
		if (children.isEmpty()) {
			count++;
			return;
		}

		for (int child : children) {
			if (!visited[child]) {
				visited[child] = true;
				count_leaf(child);
			}
		}
	}

	public static void deleteSubtree(int node) {
		for (int child : tree.get(node)) {
			deleteSubtree(child); // 먼저 자식부터 삭제
		}
		tree.set(node, new ArrayList<>()); // 마지막에 자기 자신 비우기

		for (List<Integer> children : tree) {
			children.removeIf(child -> child == node);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int parent  = Integer.parseInt(st.nextToken());
			if (parent  == -1) {
				root = i;
			} else {
				tree.get(parent ).add(i);
			}
		}
		int delNode = Integer.parseInt(br.readLine());
		if (delNode == root) {
			System.out.println(0);
		} else {
			deleteSubtree(delNode);
			count_leaf(root);
			System.out.println(count);
		}
	}
}
/*
 *         0
 *       /  |
 *     1    2
 *   /  |
 *  3   4
 *  이렇게 트리가 있을 때
 *  입력으로 노드의 부모가 들어온다.
 *  0 1 2 3 4 (노드 번호 : 자식)
 * -1 0 0 1 1 (부모 노드 번호)
 * if st == -1 이면 root 인것임
 * 인접 리스트로 부모-자식간의 노드 간선을 넣어준다.
 * -> 트리가 만들어진다.
 * 삭제할 노드 번호가 주어진다.
 * 트리를 돌면서 해당 노드 번호에게 자식이 있다면 트리에서 삭제 시킨다. !!중요
 * 리프 노드는 어떻게 구하는가?
 * => dfs를 통해서 더이상 자식이 없는경우 leaf_node++ 해서
 */