package board.poster_utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.utility.StrPrinter;
import site.utility.Constants;

public class PostScaner {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StrPrinter strPrinter = new StrPrinter();
	LastPost lastPost = new LastPost();

	Statement st = null;
	ResultSet result = null;

	public int scan(Statement st) {
		int lastPostNumber = lastPost.retrunLastPost(st);
		while (true) {
			strPrinter.inputPost();
			try {
				int postNumber = Integer.parseInt(br.readLine());

				if (postNumber == Constants.EXIT) {
					return Constants.EXIT;
				} else if (postNumber > lastPostNumber) {
					strPrinter.missPost();
					return Constants.MISS_POST;
				}

				result = st.executeQuery("select * from " + Constants.BOARD_TABLE_NAME + " where b_num =" + postNumber);

				if (result.next()) {
					return postNumber;
				} else {
					break;
				}

			} catch (SQLException e) {
				strPrinter.missPost();
			} catch (IOException e) {
				strPrinter.checkInput();
			}
		}
		return Constants.MISS_POST;
	}

}