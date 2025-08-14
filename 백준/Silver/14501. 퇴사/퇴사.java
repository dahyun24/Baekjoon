import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n];
        int[] P = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        // i번째 날에 도달했을 때의 최대 수익
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            // 상담을 하는 경우
            if (i+T[i] <= n) {
                dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i]);
            }
            // 상담을 하지 않는 경우, 현재까지의 최대 수익 dp[i]와 비교해서 큰 값 유지
            dp[i+1] =  Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[n]);
    }
}
