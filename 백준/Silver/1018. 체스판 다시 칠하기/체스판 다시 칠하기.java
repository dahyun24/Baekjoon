import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 모든 8*8 구간을 돌면서 최소로 칠하는 값을 구하기
        int count = Integer.MAX_VALUE;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                count = Math.min(count, chessPaint(i,j));
            }
        }
        System.out.println(count);

    }

    // 흰색 부터 시작하는 경우와 검정색 부터 시작하는 경우 다시 페인트를 칠하는 횟수를 반환
    private static int chessPaint(int i, int j) {
        int whiteS = 0;
        int blackS = 0;
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                char ch = board[i+k][j+l];
                // (k+l) 짝수면 시작색, 홀수면 반대색
                char white = ((k+l) % 2 ==0) ? 'W' : 'B';
                char black = ((k+l) % 2 ==0) ? 'B' : 'W';
                if (ch != white) whiteS++;
                if (ch != black) blackS++;
            }
        }
        return Math.min(whiteS,blackS);
    }
}