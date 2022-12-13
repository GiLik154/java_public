package cargame;

public class Car { // 자동차 배열 생성
    Print score = new Print();

    public void matchCar(int carCount, int moveCount) {
        String[] carScore = new String[carCount]; // 차 배열 크기 설정

        for (int i = 0; i < moveCount; i++) { // 카운트 만큼 반복
            System.out.println(i+"회 반복");
            score.printScore(carCount, carScore);
        }
    }
}