package example2;

public class ProcMenuDessert {

	public static void run() {
		
		for(Product p:KioskObj.products) {
			System.out.println(p.name +" " + p.price + "��");
		}
		yy:while(true) {
			
			System.out.println("[1.��������ũ / 2.��������ũ / 3.�ٴҶ�����ũ / x.�����޴���]");
			System.out.println("");
			Kiosk.cmd = Kiosk.sc.next();
			switch(Kiosk.cmd) {
			case "1" :
				System.out.println("��������ũ ����");
				KioskObj.basket.add(new Order(KioskObj.products.get(3)));
				break;
			case "2" :
				System.out.println("��������ũ ����");
				KioskObj.basket.add(new Order(KioskObj.products.get(4)));
				break;
			case "3" :
				System.out.println("�ٴҶ�����ũ ����");
				KioskObj.basket.add(new Order(KioskObj.products.get(5)));
				break;
			case "x" :
				System.out.println("���� �޴� �̵�");
				break yy;
				
			}
		}
	}
}
