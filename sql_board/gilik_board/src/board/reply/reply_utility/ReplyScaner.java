package board.reply.reply_utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.util.utility.StrPrinter;
import site.util.utility.Constants;

public class ReplyScaner {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StrPrinter strPrinter = new StrPrinter();
	LastReply lastReply = new LastReply();

	Statement st = null;
	ResultSet result = null;

	public int scan(Statement st) {
		int lastReplyNumber = lastReply.retrunLastReply(st);

		while (true) {

			strPrinter.inputPost();

			try {
				int replyNumber = Integer.parseInt(br.readLine());

				if (replyNumber == Constants.EXIT) {
					return Constants.EXIT;
				} else if (replyNumber > lastReplyNumber) {
					strPrinter.missPost();
					return Constants.MISS_POST;
				}

				result = st.executeQuery("select * from reply where b_reply_num =" + replyNumber);

				if (result.next()) {
					return replyNumber;
				} else {
					break;
				}

			} catch (SQLException e) {
				strPrinter.missPost();
			} catch (IOException e) {
				strPrinter.checkInput();
			}
		}
		return Constants.MISS_POST;
	}

}