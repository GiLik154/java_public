package game;

public class Sword extends Item {
	int attack;

	//alt + shift + s
	
	
	
	void slash() {
		System.out.println(name+"으로 "+attack+" 데미지로 공격함"+weight);
	}

	
	
	public Sword(String name,int grade,int attack,int weight,int life) {
		super(name,grade,weight,life);
		this.attack = attack;
	}

	
}
