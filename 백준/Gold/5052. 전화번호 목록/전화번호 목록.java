import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0){
            int t = sc.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                list.add(sc.next());
            }
            Collections.sort(list);
            boolean isConsistent = true;
            for (int i = 0; i < t - 1; i++) {
                if (list.get(i+1).startsWith(list.get(i))) {
                    isConsistent = false;
                    break;
                }
            }

            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}