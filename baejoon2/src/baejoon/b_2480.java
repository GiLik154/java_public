package baejoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class b_2480 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		List<Integer> dice = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			dice.add(sc.nextInt());
		}
		int max = Collections.max(dice);
		int result = 0;
		int sameNum = 0;

		for (int i = 0; i < dice.size(); i++) {
			for (int j = i; j < dice.size(); j++) {
				if (i != j && dice.get(i) == dice.get(j)) {
					result++;
					sameNum = dice.get(i);
				}
			}
		}

		switch (result) {
		case 1:
			System.out.println(1000 + sameNum * 100);
			break;
		case 3:
			System.out.println(10000 + sameNum * 1000);
			break;
		default:
			System.out.println(max * 100);
			break;
		}

	}
}
