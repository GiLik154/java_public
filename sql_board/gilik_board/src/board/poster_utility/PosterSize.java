package board.poster_utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import site.utility.Constants;

public class PosterSize {
	Statement st = null;
	ResultSet result = null;

	public int printSize(Statement st) {
		int boardSize = 0;
		try {
			result = st.executeQuery("select count(*) from " + Constants.BOARD_TABLE_NAME + ";");
			result.next();
			boardSize = result.getInt("count(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardSize;
	}

}
