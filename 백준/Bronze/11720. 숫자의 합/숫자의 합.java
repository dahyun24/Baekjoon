import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		String num = scanner.next();
		scanner.close();
		
		int sum =0;
		
		for(int i = 0; i < N ; i++) {
			sum += num.charAt(i)-'0';
			// charAt은 아스키코드를 반환하므로 '0'이 필요하다.
		}
		System.out.print(sum);
	}

}
