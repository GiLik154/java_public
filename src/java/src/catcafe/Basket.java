package catcafe;

import java.util.ArrayList;
import java.util.List;

class Basket {
    List<GoodsInfo> cart = new ArrayList<GoodsInfo>(); // 리스트 인스턴스화
    String name = "";
    int price = 0;
    int each = 0;
    String temp = "";

    void returnCart(String name, int price, int each, String temp) { // Order에서 정보를 받아와서 리스트에 정보 전송
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.inputGood(name, price, each, temp);
        cart.add(goodsInfo);
    }

    void printCart() { // 리스트의 정보 확인 및 프린트
        int count = cart.size();
        System.out.println("장바구니에 담긴 상품 갯수:" + count);

        String sumName = "";
        int sumEach = 0;
        int sumPrice = 0;
        for (int i = 0; i < cart.size(); i = i + 1) {
            sumName = sumName + "\r\n" + cart.get(i).name + " || 음식 옵션 : " + cart.get(i).info + " || 주문 가격 : "
                    + +cart.get(i).price * cart.get(i).each;
            sumEach = sumEach + cart.get(i).each;
            sumPrice = sumPrice + cart.get(i).price * cart.get(i).each;
        }
        System.out.println("담긴 품목 :" + sumName + " ");
        System.out.println("");
        System.out.println("담긴 물건의 갯수는 : " + sumEach + "개 입니다.");
        System.out.println("");
        System.out.println("계산하실 금액은 : " + sumPrice + "원 입니다.");
        System.out.println("");

    }
}