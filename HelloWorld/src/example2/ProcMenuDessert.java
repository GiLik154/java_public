package example2;

public class ProcMenuDessert {

	public static void run() {
		
		for(Product p:KioskObj.products) {
			System.out.println(p.name +" " + p.price + "원");
		}
		yy:while(true) {
			
			System.out.println("[1.초코케이크 / 2.딸기케이크 / 3.바닐라케이크 / x.이전메뉴로]");
			System.out.println("");
			Kiosk.cmd = Kiosk.sc.next();
			switch(Kiosk.cmd) {
			case "1" :
				System.out.println("초코케이크 선택");
				KioskObj.basket.add(new Order(KioskObj.products.get(3)));
				break;
			case "2" :
				System.out.println("딸기케이크 선택");
				KioskObj.basket.add(new Order(KioskObj.products.get(4)));
				break;
			case "3" :
				System.out.println("바닐라케이크 선택");
				KioskObj.basket.add(new Order(KioskObj.products.get(5)));
				break;
			case "x" :
				System.out.println("이전 메뉴 이동");
				break yy;
				
			}
		}
	}
}
