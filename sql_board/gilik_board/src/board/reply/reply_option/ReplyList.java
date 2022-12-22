package board.reply.reply_option;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.reply.reply_utility.ReplySize;
import board.util.utility.StrPrinter;
import site.util.utility.Constants;
import site.util.utility.ConstantsReply;

public class ReplyList {

	ReplySize replySize = new ReplySize();
	StrPrinter strPrinter = new StrPrinter();

	private Statement st = null;
	private ResultSet result = null;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void run(Statement st) throws IOException {
		this.st = st;
		while (true) {

			int maxPostSize = replySize.printSize(st);
			int maxListSize = (int) (Math.ceil((double) maxPostSize / Constants.PAGE_PER_BLOCK));
			int nowPage = scanPage(maxListSize);

			if (nowPage == Constants.EXIT) {
				strPrinter.exit();
				return;

			} else {
				int listSize = (nowPage - 1) * Constants.PAGE_PER_BLOCK;

				printBoard(listSize);
				System.out.println("현재 페이지 : " + nowPage + "/" + maxListSize + "\n");
			}
		}

	}

	private int scanPage(int maxListSize) throws IOException {
		int nowPage = 0;
		while (true) {
			bw.write("몇 번째 목록을 보시겠습니까? \\ 0번 == 종료하기"+ "\n");
			bw.write("최대 페이지 : " + maxListSize+ "\n");
			bw.flush();
			try {
				nowPage = Integer.parseInt(br.readLine());

			} catch (NumberFormatException e) {
				strPrinter.notInt();
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

	private void printBoard(int listSize) {
		try {
			result = st.executeQuery("select * from " + Constants.REPLY_TABLE_NAME + " limit " + listSize + ","
					+ Constants.PAGE_PER_BLOCK);
			while (result.next()) {
				String num = result.getString(ConstantsReply.B_REPLY_NUM);
				String origin = result.getString(ConstantsReply.B_REPLY_ORIGIN);
				String contents = result.getString(ConstantsReply.B_REPLY_CONTENTS);
				String writer = result.getString(ConstantsReply.B_REPLY_WRITER);
				String time = result.getString(ConstantsReply.B_REPLY_TIME);
				System.out.println(num + "\\" + origin + "\\" + contents + "\\" + writer + "\\" + time + "\\");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}