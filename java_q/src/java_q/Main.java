package java_q;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Father> list = new ArrayList<>();
		list.add(new Son("1번 스트링", 2, "3번 스트링"));

		Son son = (Son) list;
		System.out.println(son.c + "변환완료");

		if (list instanceof Son) {
		}
		System.out.println("형변환 실패");
	}
}


