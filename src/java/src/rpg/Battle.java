package rpg;

import java.util.Random;

public class Battle {
	Random random = new Random();
	String mobName;
	int userAtt;
	int userRandomAtt;
	static int userHp;
	int mobHp;
	int mobAtt;
	int mobRandomAtt;

	void battleChar(Character Character) {
		userHp = Character.hp();
		userAtt = Character.attack();
	}

	void battleMob() {
		Monster orc = new Monster();
		orc.randomMon();

		mobName = orc.name();
		mobHp = orc.hp();
		mobAtt = orc.attack();
	}

	void battle() {
		battleMob();
		while (true) {
			userHp = userHp - random.nextInt(mobAtt + 1);
			mobHp = mobHp - random.nextInt(userAtt + 1);
			System.out.println("유저체력 : " + userHp);
			System.out.println(mobName + "체력 : " + mobHp);
			if (userHp > 0 && mobHp <= 0) {
				System.out.println("승리하였습니다.");
				break;
			} else if (userHp <= 0 && mobHp > 0) {
				System.out.println("패배하였습니다.");
					break;
			}
		}

	}

	static int returnhp() {
		return userHp;
	}
}
