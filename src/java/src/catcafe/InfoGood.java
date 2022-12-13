package catcafe;

public class InfoGood {
    ScannerInput scanner = new ScannerInput();
    String info = "";

    String hotOrICed() { // 뜨거운거, 아이스 고르기
        while (true) {
            System.out.println("온도 설정 : hot or ice");
            info = scanner.input.next();
            if (info.equals("hot") || info.equals("ice")) { // 뜨거운거 또는 차가운거면 통과
                break;
            } else {
                System.out.println("다시 입력해주세요"); // 아니면 다시 입력

            }
        }
        return info;
    }

    String cake() { // 뜨거운거, 아이스 고르기
        info = "cake";
        return info;
    }
}
