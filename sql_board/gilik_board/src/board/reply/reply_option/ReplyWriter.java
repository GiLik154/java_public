package board.reply.reply_option;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.sql.Statement;

import board.poster.poster_utility.PostScaner;
import board.util.utility.StrPrinter;
import board.util.write.BoardContents;
import site.util.utility.Constants;
import site.util.utility.ConstantsReply;

public class ReplyWriter {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	BoardContents boardContents = new BoardContents();
	StrPrinter strPrinter = new StrPrinter();
	PostScaner postScaner = new PostScaner();

	Statement st = null;

	public void run(Statement st, String id) throws IOException {
		this.st = st;
		int originPost = originPost();

		if (originPost == Constants.EXIT) {
			strPrinter.exit();
			return;
		}
		write(originPost, st, id);
	}

	private int originPost() throws IOException {
		int originPost = 0;
		bw.write("댓글을 작성합니다." + "\n");
		bw.flush();

		while (true) {
			originPost = postScaner.scan(st);
			break;
		}
		return originPost;
	}

	public void write(int originPost, Statement st, String id) {

		String contents = boardContents.scanContents();
		String writer = id;

		try {
			st.executeUpdate("insert into " + Constants.REPLY_TABLE_NAME + "(" + ConstantsReply.B_REPLY_CONTENTS + ", "
					+ ConstantsReply.B_REPLY_WRITER + ", " + ConstantsReply.B_REPLY_ORIGIN + ", "
					+ ConstantsReply.B_REPLY_TIME + ") values ('" + contents + "'," + "'" + writer + "'," + originPost
					+ "" + ",now()" + ")");
			strPrinter.resultInput();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
