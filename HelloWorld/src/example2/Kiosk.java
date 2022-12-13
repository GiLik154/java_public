package example2;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {

	public static ArrayList<Product> basket = new ArrayList<Product>();

	public static Scanner sc = new Scanner(System.in);
	public static String cmd;

	void run() {
		KioskObj.productLoad();
		Disp.title();
		xx: while (true) {
			System.out.println("명령 입력 [1.음료 선택 / 2.디저트 선택 / e.프로그램 종료] :");
			KioskObj.cmd = KioskObj.sc.next();
			switch (KioskObj.cmd) {
			case "1":
				ProcMenuDrink.run();
				break;
			case "2":
				ProcMenuDessert.run();
				break;
			case "e":
				System.out.println("장바구니에 담긴 상품 갯수: " + KioskObj.basket.size() + "개");
				int sum = 0;
				for (Order o : KioskObj.basket) {
					sum = sum + o.selectedProduct.price;
				}
				System.out.println("계산하실 금액은 : " + sum + "원 입니다.");
				System.out.println("====================");
				for (Order o : KioskObj.basket) {
					System.out.println(o.selectedProduct.name);
				}
				System.out.println("====================");
				System.out.println("프로그램종료");
				break xx;

			default:
				System.out.println("없는 메뉴입니다. 다시 선택해 주십시오.");
			}
		}
	}

}
