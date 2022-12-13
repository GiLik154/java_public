//할일 => 여기는 구매만 하는 곳. 품목 나눠야 함

package catcafe;

import java.util.InputMismatchException;

public class EspressoMenu {
    String name = "";
    int price = 0;
    int each = 0;
    String info = "";
    boolean loop = false;
    boolean buy = false;
    ScannerInput scanner = new ScannerInput();
    GoodsInfo goodsinfo = new GoodsInfo();

    boolean sellEspresso() {
        boolean loop = true;
        buy = false;
        System.out.println("============================================");
        System.out.println("================= 에소프레소 메뉴    ===========");
        System.out.println("============================================");
        System.out.print("명령: 1 : 에소프레소 || 2 : 아메리카노 3 : 라떼 || X : 종료");
        scanner.cmd = scanner.input.next();

        switch (scanner.cmd) {
            case "1":
                goodsinfo.espresso(); // 물품 불러오기
                System.out.println(goodsinfo.name + "" + goodsinfo.price + "원"); // 물품 정보 출력

                System.out.print("갯수 입력 : "); // 갯수 입력
                each = scanner.input.nextInt(); // 갯수 입력

                info = hotOrICed(); // 정보 입력 (hot, ice)

                menuEspresso(goodsinfo.name, goodsinfo.price, each, info); //정보 리턴
                buyReturn(); // 구매 할 것인지 결정
                break;

            case "2":
                goodsinfo.americano(); // 물품저장
                System.out.println(goodsinfo.name + "" + goodsinfo.price + "원");

                System.out.print("갯수 입력 : ");
                each = scanner.input.nextInt();

                info = hotOrICed();

                menuEspresso(goodsinfo.name, goodsinfo.price, each, info);
                buyReturn();
                break;

            case "3":
                goodsinfo.latte(); // 물품저장
                System.out.println(goodsinfo.name + "" + goodsinfo.price + "원");

                System.out.print("갯수 입력 : ");
                each = scanner.input.nextInt();

                info = hotOrICed();

                menuEspresso(goodsinfo.name, goodsinfo.price, each, info);
                buyReturn();
                break;

            case "x":
                loop = false;

            default:
                System.out.println("입력을 확인해주세요.");
                break;
        }
        return loop;
    }

    void buyEspresso(boolean buy) {
        this.buy = buy;
        if (buy == true) { // buy가 true 일경우 주문 완료
            System.out.println("주문하였습니다.");
            System.out.println("============================================");
        } else if (buy == false) { // buy가 flase 일경우 주문 취소
            System.out.println("취소하였습니다.");
            System.out.println("============================================");
        }
    }

    void buyReturn() {
        while (true) {
            System.out.println("구매 하시겠습니까? [ 1 : 네 || 2 : 아니요 ]"); // 1,2만 입력.
            try { // 예외처리
                int input = 0;
                input = scanner.input.nextInt();
                if (input == 1) { // 1일 경우 buy를 true로 바꾸고 리턴
                    buy = true;
                    buyEspresso(buy);
                } else if (input == 2) { // 1일 경우 buy를 false로 바꾸고 리턴
                    buy = false;
                    buyEspresso(buy);
                } else {
                    System.out.println("다시 입력해 주세요."); // 1,2가 아니면 다시 입력
                }
                break;
            } catch (InputMismatchException error) { // 정수가 아니면 다시 입력
                scanner.input.nextLine();
                System.out.println("다시 입력해 주세요.");
            }
        }
    }

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
    void menuEspresso(String name, int price, int each, String info) { // GoodsInfo에서 받아온 정보 저장.
        this.name = name;
        this.price = price;
        this.each = each;
        this.info = info;
    }
}