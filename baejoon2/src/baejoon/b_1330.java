package baejoon;

import java.util.Scanner;

public class b_1330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		if (a > b) {
			System.out.println(">");
		} else if (a < b) {
			System.out.println("<");
		} else if (a == b) {
			System.out.println("==");
		}

	}

}
