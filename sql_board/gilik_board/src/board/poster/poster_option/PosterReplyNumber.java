package board.poster.poster_option;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import site.util.utility.Constants;
import site.util.utility.ConstantsReply;

public class PosterReplyNumber {
	private ResultSet result = null;

	int scan(Statement st, int postNumber) {
		int replyEach = 0;
		try {
			result = st.executeQuery("select * from " + Constants.REPLY_TABLE_NAME + " where "
					+ ConstantsReply.B_REPLY_ORIGIN + " =" + postNumber);
			while (result.next()) {
				replyEach++;
			}
			result.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return replyEach;
	}

}
