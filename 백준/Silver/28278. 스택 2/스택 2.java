import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 2번째 제출
/**
 * System.out.println으로 출력하는 것보다 StringBuilder에 쌓아뒀다가 한번에 출력하는 것이 좋다
 * Stack을 static으로 처음에 선언하기
 * */
public class Main {
	static final Stack<Integer> stack = new Stack<>();
	// 쌓아서 출력하는 방법
	static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫째 줄에 명령의 수 N
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			switch (a) {
				case 1:
					putStack(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					printStack1();
					break;
				case 3:
					countStack();
					break;
				case 4:
					isEmptyStack();
					break;
				case 5:	
					printStack2();
					break;
			}
		}
		System.out.println(sb);
	}

	// 1
	private static void putStack(int i) {
		stack.push(i);
	}

	// 2
	private static void printStack1() {
		if (stack.isEmpty()) {
			sb.append(-1).append("\n");
		}
		else {
			sb.append(stack.pop()).append("\n");
		}
	}

	// 3
	private static void countStack() {
		sb.append(stack.size()).append("\n");
	}

	// 4
	private static void isEmptyStack() {
		if (stack.isEmpty()) {
			sb.append(1).append("\n");
		}
		else {
			sb.append(0).append("\n");
		}
	}

	// 5
	private static void printStack2() {
		if (stack.isEmpty()) {
			sb.append(-1).append("\n");
		}
		else {
			sb.append(stack.peek()).append("\n");
		}
	}
}
