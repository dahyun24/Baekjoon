import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2); // 기본 오름차순
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (minHeap.size() == maxHeap.size()) maxHeap.offer(a);
			else minHeap.offer(a);

			if (!minHeap.isEmpty() && !maxHeap.isEmpty()){
				if (minHeap.peek() < maxHeap.peek()) {
					int tmp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(tmp);
				}
			}
			sb.append(maxHeap.peek() + "\n");
		}
		System.out.println(sb);
	}
	/**
	 * 지금까지 백준이가 말한 수 중에서 중간값을 말한다.
	 * 개수가 짝수이면 중간에 있는 두 수 중에서 작은 수를 말한다.
	 * 백준이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로
	 * 1 -> 1
	 * 1, 5 -> 1
	 * 1, 5, 2 -> sort 후 중앙값인 2
	 * 1,5,2,10
	 */
}
