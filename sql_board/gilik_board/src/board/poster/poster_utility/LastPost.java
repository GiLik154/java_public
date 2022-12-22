package board.poster.poster_utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import site.util.utility.Constants;

public class LastPost {
	Statement st = null;
	ResultSet result = null;

	public int retrunLastPost(Statement st) {
		this.st = st;
		int lastPageNumber = 0;
		try {
			result = st.executeQuery("SELECT * FROM " + Constants.BOARD_TABLE_NAME + " ORDER BY b_num DESC LIMIT 1;");

			while (result.next()) {
				lastPageNumber = Integer.parseInt(result.getString("b_num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lastPageNumber;
	}
}
