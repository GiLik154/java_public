package game;

public class Character extends GameObj {
	
	// String name;
	int hp;
	
	public Character(String name,int grade,int hp) {
		super(name,grade);	//super 함수는 무조건 맨 처음에 와야함. 룰임.
		this.hp = hp;
	}

}
