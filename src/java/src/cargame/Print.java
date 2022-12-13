package cargame;

import java.util.Random;

public class Print {
    final static int RANDOM_RANGE = 10;
    final static int CONDITION_RANGE = 4;
    Random random = new Random();

    public void printScore(int carCount, String[] carScore) {
        for (int i = 0; i < carCount; i++) { // 반복 횟수 만큰 반복
            System.out.println(carScore[i]);
            if (random.nextInt(RANDOM_RANGE) >= CONDITION_RANGE) {
                carScore[i] = carScore[i] + "-"; // 랜덤으로 돌려서 차량 카운트 + 1
            }
        }
    }
}
