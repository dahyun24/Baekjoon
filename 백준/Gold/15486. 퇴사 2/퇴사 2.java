import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n+2]; // 상담 기간
        int[] P = new int[n+2]; // 상담 보상
        int[] dp = new int[n+2]; // dp[i] = i일부터 시작했을 때 최대 수익

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 뒤에서부터 DP 채우기
        for (int i = n; i >= 1; i--) {
            if (i + T[i] <= n + 1) { // 상담이 퇴사 전 끝나는 경우
                dp[i] = Math.max(dp[i+1], P[i] + dp[i + T[i]]);
            } else { // 상담 불가능
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]); // 1일부터 시작했을 때 최대 수익
    }
}
