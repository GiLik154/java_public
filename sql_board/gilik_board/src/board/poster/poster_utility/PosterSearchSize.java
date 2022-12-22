package board.poster.poster_utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import site.util.utility.Constants;
import site.util.utility.ConstantsBoard;

public class PosterSearchSize {
	Statement st = null;
	ResultSet result = null;

	public int printSize(Statement st, String search) {
		int boardSize = 0;
		String searchStr = search;
		try {
			result = st.executeQuery("select count(case when " + ConstantsBoard.B_CONTENTS + " like '%" + searchStr
					+ "%' then 1 end) as 'serch' from " + Constants.BOARD_TABLE_NAME + ";");
			result.next();
			boardSize = result.getInt("serch");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardSize;
	}

}
