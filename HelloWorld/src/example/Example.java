package example;

import java.util.ArrayList;

public class Example {

	public static void main(String[] args) {


				ArrayList<String> animals = new ArrayList<>();
				animals.add("�����");
				animals.add("��");
				animals.add("�䳢");
				
				for(int i=0;i<animals.size();i=i+1) {
					System.out.println(animals.get(i));
				}
				
				//���� for��(for-each��� ��)
				for(String x:animals) {
					System.out.println(x);
				}
				
				int a[]= {1,2,3};
				for(int n:a) {
					System.out.println(n);
				}
				
				Cat cat1 = new Cat("ŰƼ",5);
				Cat cat2 = new Cat("����",4);
				ArrayList<Cat> cats = new ArrayList<>();
				cats.add(cat1);
				cats.add(cat2);
				for(Cat x:cats) {
					System.out.println("������̸�:"+x.name);
					System.out.println("����̳���:"+x.age);
				}
			}

		
		
		
		
		
		}
