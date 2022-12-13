package example2;

import java.util.ArrayList;
import java.util.Scanner;

public class KioskObj {

	public static ArrayList<Order>basket = new ArrayList<>();
	public static ArrayList<Product>products = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static String cmd;
	
	public static void productLoad() {
		products.add(new Product("아아" , 1000));
		products.add(new Product("뜨아" , 1500));
		products.add(new Product("오렌지주스" , 2000));
		products.add(new Product("초코케이크" , 3000));
		products.add(new Product("딸기케이크" , 4000));
		products.add(new Product("바닐라케이크" , 5000));
	
	}
			
	}
	
