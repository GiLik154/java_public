package catcafe;

import java.util.InputMismatchException;

public class ReturnEach {
    ScannerInput scanner = new ScannerInput();
    int each = 0;

    int returnEach() {
        while (true) {
            System.out.print("갯수 입력 : ");
            try { // 정수 외 예외처리
                each = scanner.input.nextInt();
                return each; // 갯수 리턴
            } catch (InputMismatchException error) { // 정수가 아니면 다시 입력
                scanner.input.nextLine();
                System.out.println("다시 입력해 주세요.");
            }
        }
    }
}
