package rpg;

public class Character {
	static String charName;
	static int charHp;
	static int charAttack;
	
	void createCharacter(String name, int hp, int attack) {
		charName = name;
		charHp = hp;
		charAttack = attack;
	}
	int hp(){
		return charHp;
	}
	int attack(){
		return charAttack;
	}
	static void reciveHp(int hp) {
	charHp = Battle.returnhp();
	}
}

