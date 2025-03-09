import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String line = br.readLine();
			if (line.equals(".")) break;

			if (line.trim().equals(".")) {
				sb.append("yes\n");
				continue;
			}

			if (validBalance(line)) {
				sb.append("yes\n");
			} else sb.append("no\n");
		}
		System.out.println(sb);
	}

	private static boolean validBalance(String line) {
		Stack<Character> stack = new Stack<>();

		for (char c : line.toCharArray()) {
			if (c == '(' || c == '[') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty() || stack.pop() != '(') return false;
			} else if (c == ']') {
				if (stack.isEmpty() || stack.pop() != '[') return false;
			}
		}
		return stack.isEmpty();
	}
}
