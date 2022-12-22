package board.poster_option;

import java.sql.SQLException;
import java.sql.Statement;

import board.utility.StrPrinter;
import board.write.BoardContents;
import board.write.BoardTitle;
import board.write.BoardWriter;
import site.utility.Constants;

public class PosterWriter {
	BoardTitle boardTitle = new BoardTitle();
	BoardWriter boardWriter = new BoardWriter();
	BoardContents boardContents = new BoardContents();
	StrPrinter strPrinter = new StrPrinter();
	Statement st = null;

	public void write(Statement st, String id) {

		String title = boardTitle.scanTitle();
		String writer = id;
		String contents = boardContents.scanContents();

		String makingboard = ("insert into " + Constants.BOARD_TABLE_NAME
				+ "(b_title,b_writer,b_time,b_contents,b_hits) values ('" + title + "'," + "'" + writer + "',now()"
				+ "," + "'" + contents + "'" + "," + "0" + ");");

		try {
			st.executeUpdate(makingboard);
			strPrinter.resultInput();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
