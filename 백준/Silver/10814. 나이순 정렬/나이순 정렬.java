import java.util.*;

class Member {
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Member> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Member m = new Member(sc.nextInt(), sc.next());
            members.add(m);
        }

        members.sort(Comparator.comparingInt(m -> m.age));

        for (Member m : members) {
            System.out.println(m.age + " " + m.name);
        }


    }
}