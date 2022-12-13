package rpg;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		int hp = Battle.returnhp();
		int heal = random.nextInt(5) + 1;
		String choice;

		Character user = new Character();
		user.createCharacter("elf", 200, 10);

		Battle start = new Battle();
		start.battleChar(user);
		
		go: while (true) {
			System.out.println("전투, 회복, 종료");
			choice = input.next();
			switch (choice) {
			case "전투":
				start.battle();
				hp = Battle.returnhp();
				break;
			case "회복":
				hp = hp + heal;
				System.out.println("체력을" + heal + "만큼 회복하였습니다." + "현재 hp :" + hp);
				break;
			case "종료":
				input.close();
				break go;

			}
		}
	}
}