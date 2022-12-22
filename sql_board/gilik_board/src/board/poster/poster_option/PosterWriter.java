package board.poster.poster_option;

import java.sql.SQLException;
import java.sql.Statement;

import board.util.utility.StrPrinter;
import board.util.write.BoardContents;
import board.util.write.BoardTitle;
import site.util.utility.Constants;
import site.util.utility.ConstantsBoard;

public class PosterWriter {
	BoardTitle boardTitle = new BoardTitle();
	BoardContents boardContents = new BoardContents();
	StrPrinter strPrinter = new StrPrinter();
	Statement st = null;

	public void write(Statement st, String id) {

		String title = boardTitle.scanTitle();
		String writer = id;
		String contents = boardContents.scanContents();

		String makingboard = ("insert into " + Constants.BOARD_TABLE_NAME + "(" + ConstantsBoard.B_TITLE + ","
				+ ConstantsBoard.B_WRITER + "," + ConstantsBoard.B_TIME + "," + ConstantsBoard.B_CONTENTS + ","
				+ ConstantsBoard.B_HITS + ") values ('" + title + "'," + "'" + writer + "',now()" + "," + "'" + contents
				+ "'" + "," + "0" + ");");

		try {
			st.executeUpdate(makingboard);
			strPrinter.resultInput();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
