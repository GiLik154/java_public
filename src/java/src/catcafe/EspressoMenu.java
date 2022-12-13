
package catcafe;

import java.util.List;

public class EspressoMenu {
    ScannerInput scanner = new ScannerInput();
    GoodsInfo goodsinfo = new GoodsInfo();
    ReturnEach returnEach = new ReturnEach();
    InfoGood infoGood = new InfoGood();
    BuyResult buyResult = new BuyResult();
    List<GoodsInfo> abcd = goodsinfo.abcde();

    String name = "";
    String info = "";
    int price = 0;
    int each = 0;
    boolean loop = false;
    boolean buy = false;

    boolean sellEspresso() {
        loop = true;
        buy = false;
        System.out.println("============================================");
        System.out.println("================= 에소프레소 메뉴    ===========");
        System.out.println("============================================");
        System.out.print("명령: 1 : 에소프레소 || 2 : 아메리카노 3 : 라떼 || X : 종료");
        scanner.cmd = scanner.input.next();

        switch (scanner.cmd) {
        case "1":
            buyProcess(1); // 구매 절차 실행
            System.out.println(abcd.indexOf("아메리카노"));

            break;

        case "2":
//            goodsinfo.americano(); // 물품저장

//            buyProcess(2);

            break;

        case "3":
//            goodsinfo.latte(); // 물품저장

//            buyProcess(3);

            break;

        case "x":
            loop = false;

        default:
            System.out.println("입력을 확인해주세요.");
            System.out.println("");
            System.out.println("============================================");
            System.out.println("");
            break;
        }
        return loop;
    }

    void buyProcess(int a) { // 구매 프로세스
        GoodsInfo goodsInfo = (GoodsInfo) abcd.get(a);
        System.out.println(goodsInfo.name + "" + goodsInfo.price + "원");

        each = returnEach.returnEach(); // each 값 리턴

        info = infoGood.hotOrICed(); //info 값 리턴

        buy = buyResult.returnBuy(); //buy 값 리턴 -> Order로 반환
        menuEspresso(goodsInfo.name, goodsInfo.price, each, info);
    }

    void menuEspresso(String name, int price, int each, String info) { // GoodsInfo에서 받아온 정보 저장.
        this.name = name;
        this.price = price;
        this.each = each;
        this.info = info;
    }
}