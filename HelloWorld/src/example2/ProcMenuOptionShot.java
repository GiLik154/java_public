package example2;

public class ProcMenuOptionShot {
	
	public static void run() {
		loop:while(true) {
			System.out.println("[1.진하게 /2.연하게 /3.이전메뉴로");
			Kiosk.cmd = KioskObj.sc.next();
			switch(Kiosk.cmd) {
			case "1":
				System.out.println("진하게 선택됨. 이전 메뉴 이동");
				KioskObj.basket.add(new Order(KioskObj.products.get(0),"strong"));
				break loop;
			case "2":
				System.out.println("연하게 선택됨. 이전 메뉴 이동");
				KioskObj.basket.add(new Order(KioskObj.products.get(0),"weak"));
				break loop;
			case "x":
				System.out.println("이전 메뉴 이동");
				break loop;
			}
			
		}
		
	}

}
