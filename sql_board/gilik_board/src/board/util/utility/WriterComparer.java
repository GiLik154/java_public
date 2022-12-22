package board.util.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import site.util.utility.Constants;
import site.util.utility.ConstantsBoard;
import site.util.utility.ConstantsReply;

public class WriterComparer {
	Statement st = null;
	ResultSet result = null;

	public boolean run(Statement st, String type, int postNumber, String id) {
		this.st = st;
		switch (type) {
		case "post":
			return comparePost(postNumber, id);

		case "reply":
			return compareReply(postNumber, id);
		}
		return false;
	}

	private boolean comparePost(int postNumber, String id) {
		try {
			result = st.executeQuery("select * from " + Constants.BOARD_TABLE_NAME + " where " + ConstantsBoard.B_NUM
					+ " =" + postNumber + ";");
			if (result.next()) {
				if (id.equals(result.getString(ConstantsBoard.B_WRITER))) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean compareReply(int replyNumber, String id) {
		try {
			result = st.executeQuery("select * from " + Constants.REPLY_TABLE_NAME + " where "
					+ ConstantsReply.B_REPLY_NUM + " =" + replyNumber + ";");
			if (result.next()) {
				if (id.equals(result.getString(ConstantsReply.B_REPLY_WRITER))) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
