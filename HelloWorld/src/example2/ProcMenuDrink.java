package example2;

public class ProcMenuDrink{
	
	public static void run() {
		for(Product p:KioskObj.products) {
			System.out.println(p.name + " " + p.price + "원");
		}
		yy:while(true) {
			
			System.out.println("[1.아아 / 2.뜨아 / 3.오렌지주스 / x.이전메뉴로]");
			System.out.println("");
			Kiosk.cmd = Kiosk.sc.next();
			switch(Kiosk.cmd) {
			case "1":
				System.out.println("아아 선택됨");
				ProcMenuOptionShot.run();
				break;
			case "2":
				System.out.println("뜨아 선택됨");
				ProcMenuOptionShot2.run();
				break;
			case "3":
				System.out.println("오렌지주스 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(2)));
				break;
			case "x":
				System.out.println("이전 메뉴 이동");
				break yy;
			
			}
		}
	}
}