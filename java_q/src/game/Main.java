package game;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// 게임 오브젝트들 로딩
		Character c = new Character("고양이",3,100);
		Sword s = new Sword("단검",2,100,50,70);
		Sword l = new Sword("장검",3,150,100,70);
		
		((GameObj)c).name = "개";
//		((Item)s).attack;	//손자가 아버지로 형변환함. 대신 자기 변수 못씀.
//		((Item)s).slash();	//손자가 아버지로 형변환함. 대신 자기 함수 못씀.
		
		////	형변환은 가족끼리만 가능	////
		
		////	각자 강제형변환 후, 할아버지 변수에 대입했음	////
		GameObj g1 = (GameObj)s;	//손자가 할아버지로 형변환함.
		GameObj g2 = (GameObj)c;	//작은아버지가 할아버지로 형변환함.
		
		////	그냥 할아버지 변수에 대입해도 자동 형변환 됨.	////
		GameObj g3 = s;	//손자가 할아버지로 형변환함.
		GameObj g4 = c;	//작은아버지가 할아버지로 형변환함.
		
//		g3.hp; // 자기꺼는 못쓰게됨.
//		g4.attack;	// 자기꺼는 못쓰게됨.
		
		ArrayList<GameObj> gf = new ArrayList<>();
		gf.add(g3);
		gf.add(g4);
		
		//// 그럼 자기꺼 쓰려면?	////
		/// : 원형으로 돌아가야함. 다시 형변환
		Sword shortSword = (Sword)g3;
		shortSword.slash(); 	// 자기 함수 이제 쓸 수 있게 됨.(또는 변수)
		
		if(g3 instanceof Sword) {
			System.out.println("얘 원래 검임");
		}
		if(g4 instanceof Character) {
			System.out.println("얘 원래 케릭임");
		}
		
		
		
		

		//할아버지형 리스트에 손자,아들,본인 다 넣을수 있음. (상속의 중요 특성)
		ArrayList<GameObj> gs = new ArrayList<>();
		gs.add(c);
		gs.add(s);
		gs.add(l);
		for(GameObj o : gs) {
			System.out.println(o.name);
			if(o instanceof Sword) {
				System.out.println(o.name + "의 공격력은 "+((Sword)o).attack);
			}
			if(o instanceof Character) {
				System.out.println(o.name + "의 체력은 "+((Character)o).hp);
			}
		}
		int n = 1 + ((Sword)gs.get(2)).attack;
		System.out.println("공격력"+n);
	}
}