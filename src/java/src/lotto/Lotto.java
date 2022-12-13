package lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	
	public static void main(String[] args) {
		Com computer = new Com();
		User user = new User();
		Result result = new Result();
		int[] userNumber = user.inputNumber();
		int[] comNumber = computer.electNumber();
		result.compareResult(userNumber, comNumber);
	}
}

class User {
	int userArr[] = new int[6];
	Scanner input = new Scanner(System.in);
	Overlap compareResult = new Overlap();

	int[] inputNumber() {
		for (int i = 0; i < userArr.length; i++) {
			System.out.println("번호를 입력하세요.");
			int userNumber = input.nextInt();
			userArr[i] = userNumber;
			System.out.println(i + 1 + "번 입력 : " + userNumber);
			if (compareResult.compareOverlap(userArr) == true) {
				System.out.println("중복되는 번호입니다..");
				i--;
			}
		}
		System.out.print("유저번호 : " + Arrays.toString(userArr));
		return userArr;
	}
}

class Com {
	int comArr[] = new int[7];
	Overlap compareResult = new Overlap();

	int[] electNumber() {
		Random random = new Random();
		for (int i = 0; i < comArr.length - 1; i++) {
			comArr[i] = random.nextInt(45) + 1;
			if (compareResult.compareOverlap(comArr) == true) {
				i--;
			}
		}

		while (true) {
			comArr[6] = random.nextInt(45) + 1;
			if (compareResult.compareOverlap(comArr) == true) {
			} else {
				break;
			}
		}
		System.out.print("컴퓨터 번호 : " + Arrays.toString(comArr));
		return comArr;
	}
}

class Overlap {
	boolean compareResult = false;

	boolean compareOverlap(int[] compareNumber) {
		compareResult = false;
		for (int i = 0; i < compareNumber.length; i++) {
			for (int j = 0; j < compareNumber.length; j++) {
				if (compareNumber[i] != 0 && i != j && compareNumber[i] == compareNumber[j]) {
					compareResult = true;
					break;
				}
			}
			if (compareResult == true) {
				break;
			}
		}
		return compareResult;
	}
}

class Result {
	int score = 0;
	int bounse = 0;

	void compareResult(int[] user, int[] com) {
		for (int i = 0; i < user.length; i++) {
			for (int j = 0; j < com.length; j++) {
				if (j != 6 && user[i] == com[j]) {
					score++;
				} else if (j == 6 && user[i] == com[j]) {
					bounse++;
					{
					}
				}
			}
		}
		Print result = new Print();
		result.printResult(score, bounse);
	}
}

class Print {
	void printResult(int score, int bounse) {
		if (score == 3) {
			System.out.println("");
			System.out.println("5등입니다.");
		} else if (score == 4) {
			System.out.println("");
			System.out.println("4등입니다.");
		} else if (score == 5) {
			System.out.println("");
			System.out.println("3등입니다.");
		} else if (score == 6 && bounse == 1) {
			System.out.println("");
			System.out.println("2등입니다.");
		} else if (score == 6 && bounse == 0) {
			System.out.println("");
			System.out.println("1등입니다.");
		} else {
			System.out.println("");
			System.out.println("미당첨입니다.");
		}
	}
}