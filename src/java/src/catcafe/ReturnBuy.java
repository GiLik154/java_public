package catcafe;

public class ReturnBuy {

    boolean returnBuy() { // 구매처리 리턴
        ScannerInput scanner = new ScannerInput();
        boolean buy = false;

        while (true) {
            System.out.println("구매 하시겠습니까? [ 1 : 네 || 2 : 아니요 ]"); // 1,2만 입력.
            scanner.cmd = scanner.input.next();
            if (scanner.cmd.equals("1")) { // 1일 경우 buy를 true로 바꾸고 리턴
                buy = true;
                break;
            } else if (scanner.cmd.equals("2")) { // 1일 경우 buy를 false로 바꾸고 리턴
                buy = false;
                break;
            } else {
                System.out.println("다시 입력해 주세요."); // 1,2가 아니면 다시 입력
            }
        }
        return buy;
    }
}
