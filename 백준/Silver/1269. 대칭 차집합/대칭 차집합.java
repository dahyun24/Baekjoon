import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for(int a = 0; a < A; a++){
            set.add(sc.nextInt());
        }
        for(int b = 0; b < B; b++){
            set.add(sc.nextInt());
        }
        System.out.print(2* set.size() - A - B);
    }
}
