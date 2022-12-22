package board.reply.reply_option;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import board.reply.reply_utility.ReplySize;
import board.util.utility.StrPrinter;
import site.util.utility.Constants;

public class ReplyList {
	private static final int PAGE_PER_BLOCK = 3;
	private static int EXIT = 0;

	ReplySize replySize = new ReplySize();
	StrPrinter strPrinter = new StrPrinter();

	private Statement st = null;
	private ResultSet result = null;

	Scanner sc = new Scanner(System.in);

	public void run(Statement st) {
		this.st = st;
		while (true) {

			int maxPostSize = replySize.printSize(st);
			int maxListSize = (int) (Math.ceil((double) maxPostSize / PAGE_PER_BLOCK));
			int nowPage = scanPage(maxListSize);

			if (nowPage == EXIT) {
				strPrinter.exit();
				return;

			} else {
				int listSize = (nowPage - 1) * PAGE_PER_BLOCK;

				printBoard(listSize);
				System.out.println("현재 페이지 : " + nowPage + "/" + maxListSize + "\n");
			}
		}

	}

	private int scanPage(int maxListSize) {
		int nowPage = 0;
		while (true) {
			System.out.println("몇 번째 목록을 보시겠습니까? \\ 0번 == 종료하기");
			System.out.println("최대 페이지 : " + maxListSize);
			nowPage = sc.nextInt();

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
			result = st.executeQuery(
					"select * from " + Constants.REPLY_TABLE_NAME + " limit " + listSize + "," + PAGE_PER_BLOCK);
			while (result.next()) {
				String num = result.getString("b_reply_num");
				String origin = result.getString("b_reply_origin");
				String contents = result.getString("b_reply_contents");
				String writer = result.getString("b_reply_writer");
				String time = result.getString("b_reply_time");
				System.out.println(num + "\\" + origin + "\\" + contents + "\\" + writer + "\\" + time + "\\");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}