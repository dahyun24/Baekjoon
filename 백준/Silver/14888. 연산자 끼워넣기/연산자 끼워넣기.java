import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static int max = Integer.MAX_VALUE * -1;
    static int min = Integer.MAX_VALUE;

    static void dfs(int idx, int cur, int p, int m, int t, int d) {
        if (idx == N) { // 모든 수 사용
            if (cur > max) max = cur;
            if (cur < min) min = cur;
            return;
        }
        int x = A[idx];
        if (p > 0) dfs(idx + 1, cur + x, p - 1, m, t, d);
        if (m > 0) dfs(idx + 1, cur - x, p, m - 1, t, d);
        if (t > 0) dfs(idx + 1, cur * x, p, m, t - 1, d);
        if (d > 0) dfs(idx + 1, cur / x, p, m, t, d - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        dfs(1, A[0], p, m, t, d);
        System.out.println(max);
        System.out.println(min);
    }
}
