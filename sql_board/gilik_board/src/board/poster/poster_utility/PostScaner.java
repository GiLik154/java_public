package board.poster.poster_utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.util.utility.StrPrinter;
import site.util.utility.Constants;
import site.util.utility.ConstantsBoard;

public class PostScaner {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StrPrinter strPrinter = new StrPrinter();
	LastPost lastPost = new LastPost();

	Statement st = null;
	ResultSet result = null;

	public int scan(Statement st) {

		while (true) {
			strPrinter.inputPost();
			try {
				int postNumber = Integer.parseInt(br.readLine());

				if (postNumber == Constants.EXIT) {
					return Constants.EXIT;
				}

				result = st.executeQuery("select * from " + Constants.BOARD_TABLE_NAME + " where "
						+ ConstantsBoard.B_NUM + " =" + postNumber);

				if (result.next()) {
					return postNumber;
				} else {
					strPrinter.missPost();
					strPrinter.checkInput();
				}

			} catch (SQLException e) {
			} catch (IOException e) {
				strPrinter.checkInput();
			} catch (NumberFormatException e) {
				strPrinter.notInt();
			}
		}
	}

}