package board.poster.poster_option;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.poster.poster_utility.PosterSize;
import board.util.utility.StrPrinter;
import site.util.utility.Constants;
import site.util.utility.ConstantsBoard;

public class PosterList {

	PosterSize posterSize = new PosterSize();
	StrPrinter strPrinter = new StrPrinter();
	PosterSerchList posterSerchList = new PosterSerchList();

	private Statement st = null;
	private ResultSet result = null;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void run(Statement st) throws IOException {
		this.st = st;
		while (true) {
			int maxPostSize = posterSize.printSize(st);
			int maxListSize = (int) (Math.ceil((double) maxPostSize / Constants.PAGE_PER_BLOCK));
			bw.write("전체 글 수 : " + maxPostSize + "\n" + "\n");

			int nowPage = scanPage(maxListSize);

			if (nowPage == Constants.EXIT) {
				strPrinter.exit();
				return;
			} else {
				int listSize = (nowPage - 1) * Constants.PAGE_PER_BLOCK;

				printList(listSize);
				bw.write("현재 페이지 : " + nowPage + "/" + maxListSize + "\n" + "\n");
			}
		}
	}

	private int scanPage(int maxListSize) throws IOException {
		int nowPage = 0;
		while (true) {
			bw.write("몇 번째 목록을 보시겠습니까? \\ 0번 == 종료하기" + "\n");
			bw.write("최대 페이지 : " + maxListSize + "\n");
			bw.flush();
			try {
				nowPage = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				bw.write("숫자로 다시 입력해주세요." + "\n");
				bw.flush();
			}
			if (nowPage > maxListSize) {
				strPrinter.checkInput();

			} else if (nowPage == 0) {
				break;
			} else {
				break;
			}
		}
		return nowPage;
	}

	private void printList(int listSize) {
		try {
			result = st.executeQuery("select * from board limit " + listSize + "," + Constants.PAGE_PER_BLOCK);
			bw.write("\n");
			while (result.next()) {
				String num = result.getString(ConstantsBoard.B_NUM);
				String title = result.getString(ConstantsBoard.B_TITLE);
				String writer = result.getString(ConstantsBoard.B_WRITER);
				String time = result.getString(ConstantsBoard.B_TIME);
				String hits = result.getString(ConstantsBoard.B_HITS);
				String contents = result.getString(ConstantsBoard.B_CONTENTS);
				bw.write(num + "\\" + title + "\\" + writer + "\\" + time + "\\" + hits + "\\" + contents + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}