import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[a];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 카드 세장의 합이 b 이하의 가장 큰 수를 찾아야한다.
        // 브루트포스를 사용하면 최대 100C3 = 100*99*98/6
        int max = 0;
        for (int i=0; i<a-2; i++){
            for (int j = i+1; j < a-1; j++) {
                for (int k = j+1; k < a ; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum <= b && sum > max) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }

}