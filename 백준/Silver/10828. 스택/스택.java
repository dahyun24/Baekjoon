import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int num  = Integer.parseInt(br.readLine());

		for(int i = 0; i < num; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			if (str.equals("pop")) {
				if (stack.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.pop() + "\n");
				}
			}
			if (str.equals("size")) {
				sb.append(stack.size() + "\n");
			}
			if (str.equals("empty")) {
				if (stack.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			}
			if (str.equals("top")) {
				if (stack.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.peek() + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}