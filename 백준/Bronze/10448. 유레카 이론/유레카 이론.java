import java.io.*;

public class Main {
    static int[] arr = new int[46];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 45; i++) {
            arr[i] = i * (i + 1) / 2;
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            boolean found = false;

            outer:
            for (int i = 1; i <= 45; i++) {
                for (int j = 1; j <= 45; j++) {
                    for (int k = 1; k <= 45; k++) {
                        if (arr[i] + arr[j] + arr[k] == K) {
                            found = true;
                            break outer;
                        }
                    }
                }
            }
            bw.write(found ? "1" : "0");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}