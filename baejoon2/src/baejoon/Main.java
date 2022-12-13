package baejoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> number = new ArrayList<Integer>();
		List<Integer> chess = new ArrayList<Integer>();
		chess.add(1);
		chess.add(1);
		chess.add(2);
		chess.add(2);
		chess.add(2);
		chess.add(8);
		int k = 5;
		for (int i = 0; i <= k; i++) {
			number.add(chess.get(i) - sc.nextInt());
		}
		for (int i = 0; i <= k; i++) {
			System.out.print(number.get(i));
			System.out.print(" ");
		}
	}

}