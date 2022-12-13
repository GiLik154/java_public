package baejoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b_2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = B;

		List<Integer> num = new ArrayList<>();

		while (B > 0) {
			num.add(B % 10);
			B = B / 10;
		}
		for(int i = 0; i < num.size(); i++) {
		System.out.println(A * num.get(i));
		}
		System.out.println(A * C);	
	}
}
