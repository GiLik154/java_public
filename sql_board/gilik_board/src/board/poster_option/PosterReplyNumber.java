package board.poster_option;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import site.utility.Constants;

public class PosterReplyNumber {
	private ResultSet result = null;

	int scan(Statement st, int postNumber) {
		int replyEach = 0;
		try {
			result = st.executeQuery(
					"select * from " + Constants.REPLY_TABLE_NAME + " where b_reply_origin =" + postNumber);
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