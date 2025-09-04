import java.io.*;

public class Main {
    /**
     * 문제는 복잡해 보이지만 결국 피보나치와 같은 풀이! 앞 두 항을 더한 결과가 뒷항이 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        if (n == 1){
            System.out.println(1);
            return;
        } else if (n == 2){
            System.out.println(2);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i] % 10007;
        }
        System.out.println(dp[n]);
    }
}
