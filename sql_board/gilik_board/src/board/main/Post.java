package board.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Statement;

import board.poster_option.PosterDeleter;
import board.poster_option.PosterList;
import board.poster_option.PosterReader;
import board.poster_option.PosterReviser;
import board.poster_option.PosterSerchList;
import board.poster_option.PosterWriter;
import board.utility.StrPrinter;

public class Post {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	PosterWriter posterWriter = new PosterWriter();
	PosterDeleter posterDeleter = new PosterDeleter();
	PosterList posterList = new PosterList();
	PosterReader posterReader = new PosterReader();
	PosterReviser posterReviser = new PosterReviser();
	StrPrinter strPrinter = new StrPrinter();
	PosterSerchList posterSerchList = new PosterSerchList();

	void selctMenu(Statement st, String id) throws IOException {
		while (true) {
			bw.write("1.게시글 메뉴입니다." + "\n");
			bw.write("1.글 리스트 \\ 2. 글 읽기 \\ 3. 글 쓰기 \\ 4. 글 삭제 \\ 5. 글 수정  \\ 0. 관리자 \\ e. 프로그램 종료" + "\n");
			bw.flush();
			String num = br.readLine();

			switch (num) {
			case "1":
				go: while (true) {
					bw.write("리스트 메뉴입니다." + "\n");
					bw.write("1.전체 목록 보기 \\ 2. 검색하기 \\ 0. 종료" + "\n");
					bw.flush();
					String list = br.readLine();
					switch (list) {
					case "1": // 글 리스트
						posterList.run(st);
						break;
					case "2":
						posterSerchList.run(st);
					case "0":
						break go;

					default:
						strPrinter.checkInput();
						break;
					}
				}
				break;

			case "2": // 글 읽기
				posterReader.run(st);
				break;

			case "3": // 글 쓰기
				posterWriter.write(st, id);
				break;

			case "4": // 글 삭제
				posterDeleter.delet(st, id);
				break;

			case "5": // 글 수정
				posterReviser.run(st, id);
				break;

			case "0":
				break;

			case "e":
				strPrinter.exit();
				return;

			default:
				strPrinter.checkInput();
				break;
			}
		}

	}
}
