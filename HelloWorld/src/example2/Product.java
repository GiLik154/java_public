package example2;

public class Product {
	//1.������
	String name;
	int price;
	
	Product(String xx, int yy){
		name = xx;
		price = yy;
	}
	
	//2.�Լ��� (���� ����)
	void info() {
		System.out.println("��ǰ��:"+name+" ����:"+price);
	}
	
}