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
			System.out.println("��� �Է� [1.���� ���� / 2.����Ʈ ���� / e.���α׷� ����] :");
			KioskObj.cmd = KioskObj.sc.next();
			switch (KioskObj.cmd) {
			case "1":
				ProcMenuDrink.run();
				break;
			case "2":
				ProcMenuDessert.run();
				break;
			case "e":
				System.out.println("��ٱ��Ͽ� ��� ��ǰ ����: " + KioskObj.basket.size() + "��");
				int sum = 0;
				for (Order o : KioskObj.basket) {
					sum = sum + o.selectedProduct.price;
				}
				System.out.println("����Ͻ� �ݾ��� : " + sum + "�� �Դϴ�.");
				System.out.println("====================");
				for (Order o : KioskObj.basket) {
					System.out.println(o.selectedProduct.name);
				}
				System.out.println("====================");
				System.out.println("���α׷�����");
				break xx;

			default:
				System.out.println("���� �޴��Դϴ�. �ٽ� ������ �ֽʽÿ�.");
			}
		}
	}

}
