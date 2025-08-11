import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int bnp;
    static int bnp_count;
    static int timing;
    static int timing_count;
    static int[] stock;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        bnp = M;
        timing = M;

        bnp_count = 0;
        timing_count = 0;

        stock = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stock[i] = Integer.parseInt(st.nextToken());
        }

        // 준현 개미
        buy_bnp();

        // 성민 개미
        buy_timing();

        int bnp_result = bnp + stock[13] * bnp_count;
        int timing_result = timing + stock[13] * timing_count;

        if (bnp_result > timing_result) {
            System.out.println("BNP");
        } else if (bnp_result == timing_result) {
            System.out.println("SAMESAME");
        } else {
            System.out.println("TIMING");
        }

    }

    private static void buy_timing() {
        int up = 0;
        int down = 0;
        for (int i = 1; i < 14; i++) {
            if (stock[i-1] < stock[i]) {
                up++;
                down=0;
            } else if (stock[i-1] > stock[i]) {
                down++;
                up=0;
            } else { up = down = 0; }

            if (up >= 3) { // 3일 연속 상승하면 매도
                if (timing > 0) {
                    timing += timing_count * stock[i];
                    timing_count = 0;
                }
            }
            else if (down >= 3) { // 3일 연속 하락하면 구매
                int buy = timing / stock[i];
                if (buy > 0) {
                    timing_count += buy;
                    timing -= buy * stock[i];
                }
            }
        }
    }

    private static void buy_bnp() {
        for (int i = 0; i < 14; i++) {
            if (bnp == 0) break;
            int buy = bnp / stock[i];
            if ( buy > 0) {
                bnp_count += buy;
                bnp -= buy * stock[i];
            }
        }
    }
}
