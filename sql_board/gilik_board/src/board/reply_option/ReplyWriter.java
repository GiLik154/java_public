package board.reply_option;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.sql.Statement;

import board.poster_utility.PostScaner;
import board.utility.StrPrinter;
import board.write.BoardContents;
import site.utility.Constants;

public class ReplyWriter {
	private static int EXIT = 0;
	private static int MISS_POST = -1;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	BoardContents boardContents = new BoardContents();
	StrPrinter strPrinter = new StrPrinter();
	PostScaner postScaner = new PostScaner();

	Statement st = null;

	public void run(Statement st, String id) {
		this.st = st;
		int originPost = originPost();

		if (originPost == EXIT) {
			strPrinter.exit();
			return;
		}
		write(originPost, id);
	}

	private int originPost() {
		int originPost = 0;
		try {
			bw.write("댓글을 작성합니다.");
			bw.flush();

			while (true) {

				originPost = postScaner.scan(st);

				if (originPost == MISS_POST) {
					strPrinter.missPost();
				}
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return originPost;
	}

	private void write(int originPost, String id) {

		String contents = boardContents.scanContents();
		String writer = id;

		try {
			st.executeUpdate("insert into " + Constants.REPLY_TABLE_NAME
					+ "(b_reply_contents, b_reply_writer, b_reply_origin, b_reply_time) values ('" + contents + "',"
					+ "'" + writer + "'," + originPost + "" + ",now()" + ")");
			strPrinter.resultInput();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
