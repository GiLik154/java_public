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
import site.util.utility.ConstantsReply;

public class ReplyScaner {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StrPrinter strPrinter = new StrPrinter();
	LastReply lastReply = new LastReply();

	Statement st = null;
	ResultSet result = null;

	public int scan(Statement st) {

		while (true) {

			strPrinter.inputPost();

			try {
				int replyNumber = Integer.parseInt(br.readLine());

				if (replyNumber == Constants.EXIT) {
					return Constants.EXIT;
				}

				result = st.executeQuery("select * from " + Constants.REPLY_TABLE_NAME + " where "
						+ ConstantsReply.B_REPLY_NUM + " =" + replyNumber);

				if (result.next()) {
					return replyNumber;
				} else {
					strPrinter.missPost();
					strPrinter.checkInput();
				}

			} catch (SQLException e) {
			} catch (IOException e) {
			} catch (NumberFormatException e) {
				strPrinter.notInt();
			}
		}
	}

}