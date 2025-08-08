import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 직사각형 input 넣기
        char[][] oblong = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                oblong[i][j] = line.charAt(j);
            }
        }

        /**
         * 크기 k 정사각형의 좌상단이 (i,j)일 때, 네 꼭짓점
         * (i,j), (i, j+k), (i+k, j), (i+k, j+k) 숫자가 같으면 성공
         */
        int maxK = Math.min(N, M) - 1;
        for (int k = maxK; k >= 0; k--) {
            for (int i = 0; i + k < N; i++) {
                for (int j = 0; j + k < M; j++) {
                    char point = oblong[i][j];
                    if (oblong[i][j + k] == point && oblong[i + k][j] == point && oblong[i + k][j + k] == point) {
                        System.out.println((k+1) * (k+1));
                        return;
                    }
                }
            }
        }
    }
}
