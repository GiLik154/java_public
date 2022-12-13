package cargame;

import java.util.Random;

public class RandomCount {

	static int generate() {
		final int random_range = 10;
		final int condition_range = 4;
		int moveAble = 0;
		Random random = new Random();

		if (random.nextInt(random_range) >= condition_range) { // 랜덤 확인
			moveAble++;
			// System.out.println(moveAble);
		}
		return moveAble;
	}
}