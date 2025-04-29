import java.io.*;
import java.util.*;

public class Main {
	static Map<String, List<String>> tree = new HashMap<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void preorder(String node) throws IOException { // 전위순회
		if (node.equals(".")) return;

		bw.write(node);// 현재 노드 방문
		List<String> children = tree.getOrDefault(node, new ArrayList<>(Arrays.asList(".", ".")));
		preorder(children.get(0)); // 왼쪽
		preorder(children.get(1)); // 오른쪽
	}

	public static void inorder(String node) throws IOException { // 중위순회
		if (node.equals(".")) return;

		List<String> children = tree.getOrDefault(node, new ArrayList<>(Arrays.asList(".", ".")));
		inorder(children.get(0)); // 왼쪽
		bw.write(node);// 현재 노드 방문
		inorder(children.get(1)); // 오른쪽
	}

	public static void postorder(String node) throws IOException { // 후위순회
		if (node.equals(".")) return;

		List<String> children = tree.getOrDefault(node, new ArrayList<>(Arrays.asList(".", ".")));
		postorder(children.get(0)); // 왼쪽
		postorder(children.get(1)); // 오른쪽
		bw.write(node);// 현재 노드 방문
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String parent = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();

			tree.put(parent, Arrays.asList(left, right));
		}

		preorder("A");
		bw.newLine();
		inorder("A");
		bw.newLine();
		postorder("A");
		bw.newLine();

		bw.flush();
		bw.close();
	}


}