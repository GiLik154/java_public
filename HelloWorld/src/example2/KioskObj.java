package example2;

import java.util.ArrayList;
import java.util.Scanner;

public class KioskObj {

	public static ArrayList<Order>basket = new ArrayList<>();
	public static ArrayList<Product>products = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static String cmd;
	
	public static void productLoad() {
		products.add(new Product("�ƾ�" , 1000));
		products.add(new Product("�߾�" , 1500));
		products.add(new Product("�������ֽ�" , 2000));
		products.add(new Product("��������ũ" , 3000));
		products.add(new Product("��������ũ" , 4000));
		products.add(new Product("�ٴҶ�����ũ" , 5000));
	
	}
			
	}
	
