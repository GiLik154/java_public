package board.reply.reply_utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import site.util.utility.Constants;
import site.util.utility.ConstantsReply;

public class LastReply {
	Statement st = null;
	ResultSet result = null;

	public int retrunLastReply(Statement st) {
		int lastReplyNumber = 0;
		try {
			result = st.executeQuery("SELECT * FROM " + Constants.REPLY_TABLE_NAME + " ORDER BY "
					+ ConstantsReply.B_REPLY_NUM + " DESC LIMIT 1;");

			while (result.next()) {
				lastReplyNumber = Integer.parseInt(result.getString("" + ConstantsReply.B_REPLY_NUM + ""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lastReplyNumber;
	}
}
