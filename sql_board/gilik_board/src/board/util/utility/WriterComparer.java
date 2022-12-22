package board.util.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import site.util.utility.Constants;

public class WriterComparer {
	Statement st = null;
	ResultSet result = null;

	public boolean run(Statement st, String type, String id, int postNumber) {
		this.st = st;
		switch (type) {
		case "post":
			return comparePost(id, postNumber);

		case "reply":
			return compareReply(id, postNumber);
		}
		return false;
	}

	private boolean comparePost(String id, int postNumber) {
		try {
			result = st
					.executeQuery("select * from " + Constants.BOARD_TABLE_NAME + " where b_num =" + postNumber + ";");
			if (result.next()) {
				if (id.equals(result.getString("b_writer"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean compareReply(String id, int replyNumber) {
		try {
			result = st.executeQuery(
					"select * from " + Constants.REPLY_TABLE_NAME + " where b_reply_num =" + replyNumber + ";");
			if (result.next()) {
				if (id.equals(result.getString("b_reply_writer"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
