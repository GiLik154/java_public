package cargame;

public class Car { // 자동차 배열 생성

	public int[] matchCar(int carCount, int moveCount) {
		int moveAble;
		int[] carData = new int[carCount]; // 차 배열 크기 설정

		for (int i = 0; i < carCount; i++) { // 차 대수 만큼 반
			moveAble = 0; // 기본값
			for (int j = 0; j < moveCount; j++) { // 반복 횟수 만큰 반복
                moveAble = moveAble + RandomCount.generate(); // 랜덤으로 돌려서 차량 카운트 + 1
            }
			carData[i] = moveAble; // 차량 정보에 대입
		}
		return carData;
	}
}