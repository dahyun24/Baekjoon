import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫째 줄에 명령의 수 N
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			switch (a) {
				case 1:
					putStack(stack, Integer.parseInt(st.nextToken()));
					break;
				case 2:
					printStack1(stack);
					break;
				case 3:
					countStack(stack);
					break;
				case 4:
					isEmptyStack(stack);
					break;
				case 5:	
					printStack2(stack);
					break;
			}
		}
	}

	// 1
	private static void putStack(Stack<Integer> stack, int i) {
		stack.push(i);
	}

	// 2
	private static void printStack1(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			System.out.println("-1");
		}
		else {
			System.out.println(stack.pop());
		}
	}

	// 3
	private static void countStack(Stack<Integer> stack) {
		System.out.println(stack.size());
	}

	// 4
	private static void isEmptyStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}

	// 5
	private static void printStack2(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			System.out.println("-1");
		}
		else {
			System.out.println(stack.peek());
		}
	}
}
