package board.reply_utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LastReply {
	Statement st = null;
	ResultSet result = null;

	public int retrunLastReply(Statement st) {
		int lastReplyNumber = 0;
		try {
			result = st.executeQuery("SELECT * FROM reply ORDER BY b_reply_num DESC LIMIT 1;");

			while (result.next()) {
				lastReplyNumber = Integer.parseInt(result.getString("b_reply_num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lastReplyNumber;
	}
}
