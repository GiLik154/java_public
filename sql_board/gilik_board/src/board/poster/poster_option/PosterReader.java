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
import board.reply.reply_option.ReplyWriter;
import board.util.utility.StrPrinter;
import site.util.utility.Constants;
import site.util.utility.ConstantsBoard;

public class PosterReader {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	PostScaner postScaner = new PostScaner();
	StrPrinter strPrinter = new StrPrinter();
	PosterReplyNumber posterReplyNumber = new PosterReplyNumber();
	ReplyWriter replyWriter = new ReplyWriter();

	Statement st = null;
	ResultSet result = null;

	public void run(Statement st, String id) {
		this.st = st;

		while (true) {

			int postNumber = postScaner.scan(st);

			if (postNumber == Constants.EXIT) {
				strPrinter.exit();
				return;
			} else {
				search(postNumber, id);
			}
		}
	}

	private void search(int postNumber, String id) {
		try {
			result = st.executeQuery("select * from " + Constants.BOARD_TABLE_NAME + " where " + ConstantsBoard.B_NUM
					+ " =" + postNumber);
			result.next();
			String title = result.getString("" + ConstantsBoard.B_TITLE + "");
			String content = result.getString("" + ConstantsBoard.B_CONTENTS + "");
			String writer = result.getString("" + ConstantsBoard.B_WRITER + "");
			addHits(result, postNumber);
			printPost(title, content, writer, postNumber, id);
			result.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void printPost(String title, String content, String writer, int postNumber, String id) {
		int replyEach = posterReplyNumber.scan(st, postNumber);
		try {
			bw.write("글제목: " + title + "\n");
			bw.write("글내용: " + content + "\n");
			bw.write("글 작성자: " + writer + "\n");
			bw.write("댓글 갯수: " + replyEach + "\n");
			bw.flush();

			writeReply(postNumber, id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeReply(int postNumber, String id) {
		try {
			while (true) {
				bw.write("댓글을 다시겠습니까? [ Y // N ]" + "\n");
				bw.flush();
				switch (br.readLine().toUpperCase()) {
				case "Y":
					replyWriter.write(postNumber, st, id);
					break;

				case "N":
					return;

				default:
					bw.write("다시 입력해주세요" + "\n");
					bw.flush();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void addHits(ResultSet result, int postNumber) {
		try {
			int hits = result.getInt("" + ConstantsBoard.B_HITS + "");
			hits = hits + 1;
			st.executeUpdate("update " + Constants.BOARD_TABLE_NAME + " set " + ConstantsBoard.B_HITS + " ='" + hits
					+ "'where " + ConstantsBoard.B_NUM + "='" + postNumber + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}