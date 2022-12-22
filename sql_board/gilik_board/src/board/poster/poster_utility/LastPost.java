package board.poster.poster_utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import site.util.utility.Constants;
import site.util.utility.ConstantsBoard;

public class LastPost {
	Statement st = null;
	ResultSet result = null;

	public int retrunLastPost(Statement st) {
		this.st = st;
		int lastPageNumber = 0;
		try {
			result = st.executeQuery("SELECT * FROM " + Constants.BOARD_TABLE_NAME + " ORDER BY " + ConstantsBoard.B_NUM
					+ " DESC LIMIT 1;");

			while (result.next()) {
				lastPageNumber = Integer.parseInt(result.getString("" + ConstantsBoard.B_NUM + ""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lastPageNumber;
	}
}
