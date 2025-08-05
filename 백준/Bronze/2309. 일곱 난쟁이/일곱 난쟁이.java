import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i =0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            list.add(n);
        }
        list.sort(Integer::compareTo);

        // 숫자 두개의 합이 sumMinus100 이 되는 조합 찾기
        int sumMinus100 = list.stream().mapToInt(Integer::intValue).sum() -100;

        outer:
        for (int i = 0; i < 9; i++){
            for (int j = i+1; j < 9; j++){
                int sum = list.get(i) + list.get(j);
                if (sum == sumMinus100){
                    list.remove(j);
                    list.remove(i);
                    break outer;
                }
            }
        }
        
        for (int n : list) {
            System.out.println(n);
        }
    }
}
