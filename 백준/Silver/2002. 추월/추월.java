import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		HashMap<String, Integer> inMap = new HashMap<>();
		String[] inOrder = new String[N];
		String[] outOrder = new String[N];

		for (int i = 0; i < N; i++) {
			inOrder[i] = br.readLine();
			inMap.put(inOrder[i], i);
		}
		for (int i = 0; i < N; i++) {
			outOrder[i] = br.readLine();
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				// inMap.get(outOrder[i])에서 나온 인덱스와 뒤에 있는 차들의 inMap 인덱스 비교하여 더 작은게 있으면 추월한 것!!
				if (inMap.get(outOrder[i]) > inMap.get(outOrder[j])) {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}