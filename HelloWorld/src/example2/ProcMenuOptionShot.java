package example2;

public class ProcMenuOptionShot {
	
	public static void run() {
		loop:while(true) {
			System.out.println("[1.���ϰ� /2.���ϰ� /3.�����޴���");
			Kiosk.cmd = KioskObj.sc.next();
			switch(Kiosk.cmd) {
			case "1":
				System.out.println("���ϰ� ���õ�. ���� �޴� �̵�");
				KioskObj.basket.add(new Order(KioskObj.products.get(0),"strong"));
				break loop;
			case "2":
				System.out.println("���ϰ� ���õ�. ���� �޴� �̵�");
				KioskObj.basket.add(new Order(KioskObj.products.get(0),"weak"));
				break loop;
			case "x":
				System.out.println("���� �޴� �̵�");
				break loop;
			}
			
		}
		
	}

}
