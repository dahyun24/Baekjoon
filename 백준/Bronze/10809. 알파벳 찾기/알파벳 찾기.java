import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String S = in.next();
		
		for(char i='a';i<='z';i++) {
			if (S.indexOf(i) != -1) {
				int index = S.indexOf(i);
				System.out.print(index + " ");
			}
			else
				System.out.print(-1 + " ");

		}
	}
}