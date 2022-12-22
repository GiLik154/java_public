package board.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Statement;

import board.util.utility.StrPrinter;

public class BoardMain {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StrPrinter strPrinter = new StrPrinter();
	Post post = new Post();
	Reply reply = new Reply();

	public void main(Statement st, String id) throws IOException {

		while (true) {
			bw.write("게시판에 오신것을 환영합니다." + "\n");
			bw.write("1.게시물 \\ 2. 댓글 \\ e. 프로그램 종료 " + "\n");
			bw.flush();
			switch (br.readLine()) { // 입력 받아 1,2,e로 넘어감
			case "1":
				post.selctMenu(st, id); // 게시물
				break;
			case "2":
				reply.selctMenu(st, id); // 댓글
				break;
			case "e":
				return;
			default:
				strPrinter.checkInput();
			}
		}

	}
}