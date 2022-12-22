package board.poster.poster_option;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.poster.poster_utility.PostScaner;
import board.util.utility.StrPrinter;
import site.util.utility.Constants;

public class PosterReader {
	private static int EXIT = 0;
	private static int MISS_POST = -1;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	PostScaner postScaner = new PostScaner();
	StrPrinter strPrinter = new StrPrinter();
	PosterReplyNumber posterReplyNumber = new PosterReplyNumber();

	Statement st = null;
	ResultSet result = null;

	public void run(Statement st) {
		this.st = st;

		while (true) {

			int postNumber = postScaner.scan(st);

			if (postNumber == EXIT) {
				strPrinter.exit();
				return;
			} else if (postNumber == MISS_POST) {
				strPrinter.missPost();
			} else {
				search(postNumber);
			}
		}
	}

	private void search(int postNumber) {
		try {
			result = st.executeQuery("select * from " + Constants.BOARD_TABLE_NAME + " where b_num =" + postNumber);
			result.next();
			String title = result.getString("b_title");
			String content = result.getString("b_contents");
			String writer = result.getString("b_writer");
			addHits(result, postNumber);
			printPost(title, content, writer, postNumber);
			result.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void printPost(String title, String content, String writer, int postNumber) {
		int replyEach = posterReplyNumber.scan(st, postNumber);
		try {
			bw.write("글제목: " + title + "\n");
			bw.write("글내용: " + content + "\n");
			bw.write("글 작성자: " + writer + "\n");
			bw.write("댓글 갯수: " + replyEach + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addHits(ResultSet result, int postNumber) {
		try {
			int hits = result.getInt("b_hits");
			hits = hits + 1;
			st.executeUpdate("update " + Constants.BOARD_TABLE_NAME + " set b_hits ='" + hits + "'where b_num='"
					+ postNumber + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}