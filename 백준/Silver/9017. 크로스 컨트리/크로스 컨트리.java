import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 입력 데이터는 표준입력을 사용한다. 입력은 T 개의 테스트 케이스로 주어진다.
 * 입력 파일의 첫 번째 줄에 테스트 케이스의 수를 나타내는 정수 T 가 주어진다.
 * 두 번째 줄부터는 두 줄에 하나의 테스트 케이스에 해당하는 데이터가 주어진다.
 * 각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N (6 ≤ N ≤ 1,000)이 주어진다.
 * 두 번째 줄에는 팀 번호를 나타내는 N 개의 정수 t1, t2, …, tN 이 공백을 사이에 두고 주어진다.
 * 각 팀은 1 과 M(1 ≤ M ≤ 200)사이의 정수로 표현된다.
 */

public class Main {
    static class TeamResult implements Comparable<TeamResult> {
        int teamId, sum, fifth;
        public TeamResult(int teamId, int sum, int fifth) {
            this.teamId = teamId;
            this.sum = sum;
            this.fifth = fifth;
        }
        @Override
        public int compareTo(TeamResult o) {
            if (this.sum != o.sum) return this.sum - o.sum;
            return this.fifth - o.fifth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // 데이터의 개수
            int N = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            // 각 팀에 6명이 존재하는지 확인
            Map<Integer, Integer> teamCount = new HashMap<>();
            for (String team : line) {
                int teamId = Integer.parseInt(team);
                teamCount.put(teamId, teamCount.getOrDefault(teamId, 0) + 1);
            }
            // 유효한 팀만 모으기
            Set<Integer> validTeams = new HashSet<>();
            for (Map.Entry<Integer, Integer> entry : teamCount.entrySet()) {
                if (entry.getValue() == 6) {
                    validTeams.add(entry.getKey());
                }
            }
            // 점수 넣기
            Map<Integer, List<Integer>> teamScores = new HashMap<>();
            int score = 1;
            for (String team : line) {
                int teamId = Integer.parseInt(team);
                if (!validTeams.contains(teamId)) continue;
                teamScores.computeIfAbsent(teamId, k -> new ArrayList<>()).add(score);
                score++;
            }
            // 팀 점수 상위 4명 합산 + 5번째 팀원 점수
            List<TeamResult> teamResults = new ArrayList<>();
            for (int team : validTeams) {
                List<Integer> scores = teamScores.get(team);
                int sum = scores.get(0) + scores.get(1) + scores.get(2) + scores.get(3);
                int fifth = scores.get(4);
                teamResults.add(new TeamResult(team, sum, fifth));
            }

            // 최종 우승자
            Collections.sort(teamResults);              // compareTo 기준으로 정렬
            System.out.println(teamResults.get(0).teamId);
        }
    }
}
