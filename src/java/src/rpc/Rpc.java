package rpc;

import java.util.Scanner;

public class Rpc {
	String userRpc;

	public static void main(String[] args) {
		Rpc abc = new Rpc();
		abc.inputRpc();
	}

	void inputRpc() {
		Scanner input = new Scanner(System.in);
		System.out.println("가위, 바위, 보 입력하세요.");
		userRpc = input.next();

		switch (userRpc) {
		case "가위":
			System.out.println("유저 입력");
			break;
		case "바위":
			break;
		case "보":
			break;
		}
	}
}