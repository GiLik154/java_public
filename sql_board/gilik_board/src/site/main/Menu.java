package site.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Statement;

import board.main.BoardMain;

public class Menu {
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	Statement st = null;

	Login login = new Login();
	Join join = new Join();
	BoardMain boardMain = new BoardMain();

	void run(Statement st) {
		this.st = st;
		String id = printNotLogin();
		if (id != null) {
			id = printLogin(id);
		}
	}

	private String printNotLogin() {
		String id = null;
		try {
			while (true) {
				bw.write("GiLik 사이트에 오신것을 환영합니다" + "\n");
				bw.write("1. 로그인 \\ 2. 회원가입 \\ 0. 종료" + "\n");
				bw.flush();

				switch (br.readLine()) {
				case "1":
					id = login.run(st);
					if (id != null) {
						return id;
					}
					break;

				case "2":
					join.run(st);
					break;

				case "3":

					break;

				case "4":

					break;

				case "0":
					return null;

				default:
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String printLogin(String id) {
		try {
			bw.write("1. 게시판 \\ 2. 관리자 \\ 0. 로그아웃" + "\n");
			bw.flush();

			switch (br.readLine()) {
			case "1":
				boardMain.main(st, id);
				break;

			case "2":

				break;

			case "0":
				return null;

			default:
				break;
			}
		} catch (IOException e) {
		}
		return null;
	}

}
