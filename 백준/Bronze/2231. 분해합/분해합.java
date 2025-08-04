import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            int result = i;
            int num = i;

            while (num > 0) {
                result += num % 10;
                num /= 10;
            }

            if (result == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}