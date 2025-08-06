import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int yhRank = getRank(N, M); // 영햑이 점수

        List<Integer> cards = new ArrayList<>();
        // 1부터 10까지 두번 카드 넣기
        for (int i = 1; i <= 10; i++) {
            cards.add(i);
            cards.add(i);
        }
        cards.remove(Integer.valueOf(N));
        cards.remove(Integer.valueOf(M));

        int count = 0;
        for (int i = 0; i < 18; i++) {
            for (int j = i+1; j < 18; j++) {
                int card1 = cards.get(i);
                int card2 = cards.get(j);
                int rank = getRank(card1, card2);
                // 영학이가 이기는 횟수 count
                if (rank < yhRank) {
                    count++;
                }
            }
        }
        System.out.printf("%.3f", (double) count / 153);

    }

    static int getRank(int x, int y) {
        if (x == y) return 10 + x;  // 1땡 ~ 10땡 → 11 ~ 20
        return (x + y) % 10;        // 끗 → 0 ~ 9
    }

}