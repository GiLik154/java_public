package cargame;

public class Print {

	void printScore(int carCount, int moveCount, int[] carData) {

		for (int i = 0; i < moveCount + 1; i++) { // 카운트 만큼 반복
			System.out.println(i + "회진행");
			for (int j = 0; j < carCount; j++) { // 차량의 대수 만큼 반복
				for (int k = 0; k < carData[j] + 1; k++) { // 차량의 점수만큼 반복
					if (k < i + 1) {
						System.out.print("-");
					}
				}
				System.out.println("");
			}
		}
	}
}