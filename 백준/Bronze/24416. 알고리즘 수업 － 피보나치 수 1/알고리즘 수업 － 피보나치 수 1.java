import java.io.*;

public class Main {
    static int count1 = 0; // 재귀 호출 횟수
    static int count2 = 0; // DP 연산 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        System.out.println(count1 + " " + count2);
    }

    // 재귀 방식
    static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // DP 방식
    static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            count2++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
