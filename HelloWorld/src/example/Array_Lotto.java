package example;

public class Array_Lotto {

	public static void main(String[] args) {
		
		int comLotto[] = new int[6];
		for(int i = 0; i < 6; i++) {
			comLotto[i] = (int)(Math.random()*45)+1;
			for(int j = 0; j < i; j++ ) {
				if(comLotto[i] == comLotto[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("�ζǹ�ȣ : ");
		
		for(int i = 0; i < 6; i++) {
			System.out.print(comLotto[i] + ",");
		}
		
		int userLotto[] = new int[6];
		for(int i = 0 ;  i < 6; i++) {
			userLotto[i] = (int)(Math.random()*45)+1;
			for(int j = 0; j < i; j++) {
				if(userLotto[i] == userLotto[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println();
		System.out.println("������ȣ : ");
		
		for(int i = 0; i < 6; i++) {
			System.out.print(userLotto[i] + ",");
		}
		
		int count = 0;
		for(int i = 0; i < userLotto.length; i++) {
			for( int j = 0; j < comLotto.length; j++) {
				if(userLotto[i] == comLotto[j]) {
					count++;
				}
			}
		}
			
	
		int bonus = (int)(Math.random()*45)+1;
		for(int i = 0; i < 6; i++) {
			if(comLotto[i] == bonus) {
				i--;
				break;
			} 
		}
		System.out.println();
		System.out.println("���ʽ���ȣ : " + bonus);
		System.out.println("��÷���� : " + count + "��");
		
		int bonus_win = 0;
		for(int i = 0; i < userLotto.length; i++) {
			if(userLotto[i] == bonus) {
				bonus_win++;
			}
		}
		
		switch(count) {
		
		case 0 :
		case 1 :
		case 2 :
				System.out.println("-----�̴�÷�Դϴ�.-----");
				break;
		case 3 :
				System.out.println("-----5���Դϴ�.-----");
				break;
		case 4 : 
			System.out.println("-----4���Դϴ�.-----");
			break;
		case 5 :
			if(bonus_win == 0) {
				System.out.println("-----3���Դϴ�.-----");
			}else {
					System.out.println("-----2���Դϴ�.-----");
				}
		case 6 : 
			System.out.println("-----1���Դϴ�.-----");
			}
		}

}


