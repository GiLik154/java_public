package baejoon;

import java.util.Scanner;

public class b_25304 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		int price = 0;
		
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			price = price + a * b;
		}
		
		if(x == price) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
