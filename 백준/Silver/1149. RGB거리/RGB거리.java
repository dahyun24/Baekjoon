import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> paint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paint = new ArrayList<>();
        StringTokenizer st;
        // 입력 채우기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            paint.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                paint.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] dp = new int[n+1][3];

        // 초기값(dp[0][j]) 은 paint.get(0).get(j) 로 세팅
        for (int j = 0; j < 3; j++)
            dp[0][j] = paint.get(0).get(j);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[i-1][k]);
                    }
                }
                dp[i][j] = cost(i,j) + min;
            }
        }
        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
    }

    static int cost(int i,int j) {
        return paint.get(i).get(j);
    }
}
