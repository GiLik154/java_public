package board.poster.poster_option;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.poster.poster_utility.PosterSearchSize;
import board.util.utility.StrPrinter;
import site.util.utility.Constants;
import site.util.utility.ConstantsBoard;

public class PosterSerchList {

	PosterSearchSize posterSearchSize = new PosterSearchSize();
	StrPrinter strPrinter = new StrPrinter();

	private Statement st = null;
	private ResultSet result = null;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void run(Statement st) {
		this.st = st;
		try {
			bw.write("검색할 단어를 입력해주세요" + "\n");
			bw.flush();
			String serach = br.readLine();
			while (true) {

				int maxPostSize = posterSearchSize.printSize(st, serach);
				int maxListSize = (int) (Math.ceil((double) maxPostSize / Constants.PAGE_PER_BLOCK));

				int nowPage = scanPage(maxListSize);

				if (nowPage == Constants.EXIT) {
					strPrinter.exit();
					return;

				} else {
					int listSize = (nowPage - 1) * Constants.PAGE_PER_BLOCK;

					serchPrint(listSize, serach);
					bw.write("현재 페이지 : " + nowPage + "/" + maxListSize + "\n" + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int scanPage(int maxListSize) {
		int nowPage = 0;
		try {
			while (true) {
				bw.write("몇 번째 목록을 보시겠습니까? \\ 0번 == 종료하기" + "\n");
				bw.write("최대 페이지 : " + maxListSize + "\n");
				bw.flush();
				nowPage = Integer.parseInt(br.readLine());

				if (nowPage > maxListSize) {
					strPrinter.checkInput();

				} else if (nowPage == 0) {
					break;
				} else {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			strPrinter.notInt();
		}
		return nowPage;
	}

	private void serchPrint(int listSize, String serch) {
		try {
			result = st.executeQuery(
					"select * from " + Constants.BOARD_TABLE_NAME + " where " + ConstantsBoard.B_CONTENTS + " like "
							+ "'%" + serch + "%'" + " limit " + listSize + "," + Constants.PAGE_PER_BLOCK + ";");
			bw.write("\n");
			while (result.next()) {
				String num = result.getString(ConstantsBoard.B_NUM);
				String title = result.getString(ConstantsBoard.B_TITLE);
				String contents = result.getString(ConstantsBoard.B_CONTENTS);
				String writer = result.getString(ConstantsBoard.B_WRITER);
				String time = result.getString(ConstantsBoard.B_TIME);
				String hits = result.getString(ConstantsBoard.B_HITS);
				bw.write(num + "\\" + title + "\\" + writer + "\\" + time + "\\" + hits + "\\" + contents + "\n");
			}
			bw.flush();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}