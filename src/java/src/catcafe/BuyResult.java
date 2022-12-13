package catcafe;

public class BuyResult {
    ReturnBuy returnBuy = new ReturnBuy();
    boolean buy = false;

    boolean returnBuy() {
        this.buy = returnBuy.returnBuy();
        if (buy == true) { // buy가 true 일경우 주문 완료
            System.out.println("주문하였습니다.");
            System.out.println("============================================");
        } else if (buy == false) { // buy가 false 일경우 주문 취소
            System.out.println("취소하였습니다.");
            System.out.println("============================================");
        }
        return buy;
    }
}
