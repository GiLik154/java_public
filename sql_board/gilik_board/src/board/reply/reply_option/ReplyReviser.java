package board.reply.reply_option;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.poster.poster_utility.LastPost;
import board.reply.reply_utility.ReplyScaner;
import board.util.utility.StrPrinter;
import board.util.utility.WriterComparer;
import board.util.write.BoardContents;
import board.util.write.BoardTitle;
import board.util.write.BoardWriter;
import site.util.utility.Constants;

public class ReplyReviser {

	private static int EXIT = 0;
	private static int MISS_POST = -1;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StrPrinter strPrinter = new StrPrinter();
	BoardTitle boardTitle = new BoardTitle();
	BoardWriter boardWriter = new BoardWriter();
	BoardContents boardContents = new BoardContents();
	LastPost lastPost = new LastPost();
	ReplyScaner replyScaner = new ReplyScaner();
	WriterComparer writerComparer = new WriterComparer();

	Statement st = null;
	ResultSet result = null;

	public void run(Statement st, String id) {
		this.st = st;
		while (true) {

			try {
				bw.write("댓글을 수정합니다." + "\n");
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

			int replyNumber = replyScaner.scan(st);

			if (replyNumber == EXIT) {
				strPrinter.exit();
				return;
			} else if (replyNumber == MISS_POST) {
				strPrinter.missPost();
			} else {
				compareId(id, replyNumber);
			}
		}
	}

	private void compareId(String id, int replyNumber) {
		if (writerComparer.run(st, "reply", id, replyNumber)) {
			int reviseOption = scanOption();
			splitOption(reviseOption, replyNumber);
		} else {
			strPrinter.notWriter();
			return;
		}
	}

	private int scanOption() {
		int menu = 0;
		while (true) {
			try {
				bw.write("어느것을 수정하시나요?" + "\n");
				bw.write("1. 내용 \\ 0. 종료" + "\n");
				bw.flush();

				menu = Integer.parseInt(br.readLine());

				if (menu == EXIT) {
					return EXIT;
				} else {
					return menu;
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				strPrinter.checkInput();
			}
		}
	}

	private void splitOption(int menu, int postNumber) {
		while (true) {

			switch (menu) {
			case 1: // 내용 수정
				reviseContents(postNumber);
				return;

			case 0: // 종료
				strPrinter.exit();
				return;

			default:
				strPrinter.checkInput();
				break;
			}
		}
	}

	private void reviseContents(int postNumber) {
		try {
			bw.write("내용을 수정합니다.");
			bw.flush();
			String newContents = boardContents.scanContents();
			st.executeUpdate("update " + Constants.REPLY_TABLE_NAME + " set b_reply_contents ='" + newContents
					+ "'where b_reply_num='" + postNumber + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}