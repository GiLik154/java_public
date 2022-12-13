package baejoon;

import java.util.Scanner;

public class b_2884 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int min = sc.nextInt();
		int resultMin = min - 45;

		if (resultMin < 0) {
			hour = hour -1;
			resultMin = resultMin + 60;
		}
		if (hour < 0) {
			hour = hour +24;
		}
		System.out.println(hour + " " + resultMin);
	}
}
