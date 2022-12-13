package game;

public class Item extends GameObj {
	int weight;	//무게
	int life;	//아이템 수명
	Item(String name, int grade, int weight, int life){
		super(name,grade);
		this.weight = weight;
		this.life = life;
	}
}
