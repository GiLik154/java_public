package rpg;

import java.util.Random;

public class Monster {
	String name;
	int hp;
	int attack;
	
	void randomMon() {
		Random random = new Random();
		int mob = random.nextInt(5);
		
		switch(mob) {
		case 0 :
			createMonster("오크", 100, 5);
			break;
		case 1 :
			createMonster("고블린", 50, 3);
			break;
		case 2 :
			createMonster("트롤", 150, 10);
			break;
		case 3 :
			createMonster("가고일", 100, 7);
			break;
		case 4 :
			createMonster("슬라임", 10, 1);
			break;
		
		}
	}

	void createMonster(String name, int hp, int attack) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
	}

	int hp() {
		return hp;
	}
	
	String name() {
		return name;
	}

	int attack() {
		return attack;
	}
}
