package board.reply.reply_option;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.reply.reply_utility.ReplyScaner;
import board.util.utility.StrPrinter;
import site.util.utility.Constants;
import site.util.utility.ConstantsReply;

public class ReplyReader {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	ReplyScaner replyScaner = new ReplyScaner();
	StrPrinter strPrinter = new StrPrinter();

	Statement st = null;
	ResultSet result = null;

	public void run(Statement st) {
		this.st = st;

		while (true) {

			int replyNumber = replyScaner.scan(st);

			if (replyNumber == Constants.EXIT) {
				strPrinter.exit();
				return;
			} else if (replyNumber == Constants.MISS_POST) {
				strPrinter.missPost();
			} else {
				search(replyNumber);
			}
		}
	}

	private void search(int replyNumber) {
		try {
			result = st.executeQuery("select * from " + Constants.REPLY_TABLE_NAME + " where "
					+ ConstantsReply.B_REPLY_NUM + " =" + replyNumber);

			result.next(); // 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
			String content = result.getString("" + ConstantsReply.B_REPLY_CONTENTS + ""); // p_name 필드(열) 의 데이터 꺼내기(1개
																							// 꺼낸거에서)
			String writer = result.getString("" + ConstantsReply.B_REPLY_WRITER + ""); // p_name 필드(열) 의 데이터 꺼내기(1개
																						// 꺼낸거에서)
			printPost(content, writer);

		} catch (SQLException e) {
		}
	}

	private void printPost(String content, String writer) {
		try {
			bw.write("댓글 내용: " + content + "\n");
			bw.write("댓글 작성자: " + writer + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}