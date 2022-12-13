package cargame;

import java.util.Scanner;

class Input {
    int carCount;
    int moveCount;
    Scanner input = new Scanner(System.in);

    int carCountScan() { // 정보입력
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = input.nextInt();
        System.out.println(carCount + "대");
        return carCount;
    }

    int moveCountScan() { // 정보입력
        System.out.println("시도할 횟수는 몇 회 인가요?");
        moveCount = input.nextInt();
        System.out.println(moveCount + "번");
        return moveCount;
    }
    
    void closeScanner() {
        input.close();
    }
}