import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static final List<Integer> list = new ArrayList<>();

	// <숫자, 빈도>
	public static final Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 개수
		int sum = 0;

		for (int i =0; i < N; i++) {
			int k = Integer.parseInt(br.readLine());
			list.add(k);
			int a = map.getOrDefault(k, 0);
			if (a == 0) {
				map.put(k, 1);
			} else map.put(k, a+1);
			sum += k;
		}

		list.sort(Integer::compareTo);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write((int) Math.round((double) sum / N) + "\n");
		bw.write(list.get((N-1)/2)+"\n");
		bw.write(getMostFrequent(N)+"\n");
		bw.write(list.get(N-1)-list.get(0) + "\n");
		bw.flush();
	}

	public static int getMostFrequent(int N) {
		int maxCount = 0;

		for (int key : map.keySet()) {
			maxCount = Math.max(maxCount, map.get(key));
		}

		// 최빈값 후보 수집
		List<Integer> modes = new ArrayList<>();
		for (int key : map.keySet()) {
			if (map.get(key) == maxCount) {
				modes.add(key);
			}
		}

		// 정렬 후 두 번째로 작은 값 반환
		modes.sort(Integer::compareTo);
		if (modes.size() == 1) {
			return modes.get(0);
		} else {
			return modes.get(1);
		}
	}
}
