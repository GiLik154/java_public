package catcafe;

public class Order {
    Basket printBasket = new Basket();
    boolean loop = true;
    boolean buyCheck = false;

    void drinkOrder() {
        loop = true;
        while (loop) {
            buyCheck = false;
            EspressoMenu espressoMenu = new EspressoMenu(); // 에스프레소 메뉴 인스턴스화
            loop = espressoMenu.sellEspresso(); // 주문이 끝났는지 확인 (loop 벗어나기 위해서)
            buyCheck = espressoMenu.buy; // 구매 했는지, 취소 했는지 buy값을 리턴 받아서 확인
            if (buyCheck) { // buyCheck의 값 확인 -> 트루면 아래 값 실행
                printBasket.returnCart(espressoMenu.name, espressoMenu.price, espressoMenu.each, espressoMenu.info); // 구매 하였으면 구매한 정보를 returnCart에 리턴
                printBasket.printCart(); // 장바구니 출력
            } else { // false 일 경우 실행
                printBasket.printCart();// 장바구니 출력
            }
        }
    }

    void cakeOrder() {
        loop = true;
        while (loop) {
            Cake cake = new Cake();
            loop = cake.sellCake();
            buyCheck = cake.buy;
            if (buyCheck) {
                printBasket.returnCart(cake.name, cake.price, cake.each, cake.info);
                printBasket.printCart();
            } else {
                printBasket.printCart();
            }
        }
    }

    void checkBasket() {
        printBasket.printCart();
    }
}