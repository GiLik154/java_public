package example2;

public class ProcMenuDrink{
	
	public static void run() {
		for(Product p:KioskObj.products) {
			System.out.println(p.name + " " + p.price + "��");
		}
		yy:while(true) {
			
			System.out.println("[1.�ƾ� / 2.�߾� / 3.�������ֽ� / x.�����޴���]");
			System.out.println("");
			Kiosk.cmd = Kiosk.sc.next();
			switch(Kiosk.cmd) {
			case "1":
				System.out.println("�ƾ� ���õ�");
				ProcMenuOptionShot.run();
				break;
			case "2":
				System.out.println("�߾� ���õ�");
				ProcMenuOptionShot2.run();
				break;
			case "3":
				System.out.println("�������ֽ� ���õ�");
				KioskObj.basket.add(new Order(KioskObj.products.get(2)));
				break;
			case "x":
				System.out.println("���� �޴� �̵�");
				break yy;
			
			}
		}
	}
}