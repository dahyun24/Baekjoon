import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] startlink;
    static int min = Integer.MAX_VALUE;
    static List<Integer> start = new ArrayList<>();
    static List<Integer> link = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        startlink = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                startlink[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /**
         * 스타트 팀과 링크 팀으로 n/2로 나눈다.
         * 각 팀원들에 대해서 능력치 쌍을 더한다.
         * 스타트 팀의 능력치와 링크 팀의 능력치가 최소가 되는 경우, 해당 최소값을 반환
         */
        // 기본으로 0은 start에 넣고,  n-1개 중에서 n/2 - 1개를 고르면 start 팀
        start.add(0);
        // 백트래킹 조합
        pick(1, n/2 - 1);
        System.out.print(min);
    }

    /**
     * 팀을 나누는 함수
     * @param idx - 현재 살펴볼 번호
     * @param need - start 팀에 더 뽑아야 하는 인원 수
     */
    static void pick(int idx, int need) {
        if (need == 0) {
            // link 만 만들어주면 된다. start가 포함하지 않는 수 넣기
            link.clear();
            boolean[] inStart = new boolean[n];
            for (int v : start) inStart[v] = true;
            for (int i = 1; i < n; i++) if (!inStart[i]) {
                link.add(i);
            }

            int diff = Math.abs(score(start) - score(link));
            if (diff < min) {
                min = diff;
            }
            return;
        }
        if (idx >= n) return;

        // 가지치기: 남은 후보 수가 need 보다 적으면 불가
        if (n-idx < need) return;

        start.add(idx);
        pick(idx+1, need-1);
        start.remove(start.size()-1);

        // 현재 idx 포함하지 않는 경우
        pick(idx+1, need);
    }

    private static int score(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int a = list.get(i), b = list.get(j);
                sum += startlink[a][b] + startlink[b][a];
            }
        }
        return sum;
    }
}
