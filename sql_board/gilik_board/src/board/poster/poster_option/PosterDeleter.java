package board.poster.poster_option;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.sql.Statement;

import board.poster.poster_utility.LastPost;
import board.poster.poster_utility.PostScaner;
import board.util.utility.StrPrinter;
import board.util.utility.WriterComparer;
import site.util.utility.Constants;
import site.util.utility.ConstantsBoard;

public class PosterDeleter {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	LastPost lastPost = new LastPost();
	StrPrinter strPrinter = new StrPrinter();
	PostScaner postScaner = new PostScaner();
	WriterComparer writerComparer = new WriterComparer();

	Statement st = null;

	public void delet(Statement st, String id) {
		this.st = st;
		while (true) {
			try {

				bw.write("글을 삭제합니다." + "\n");
				bw.flush();

				int postNumber = postScaner.scan(st);

				if (postNumber == Constants.EXIT) {
					strPrinter.exit();
					return;
				} else {
					compareId(postNumber, id);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void compareId(int postNumber, String id) throws IOException {
		if (writerComparer.run(st, "post", postNumber, id)) {
			try {
				st.executeUpdate("delete from " + Constants.BOARD_TABLE_NAME + " where " + ConstantsBoard.B_NUM + " ="
						+ postNumber + ";");
				bw.write("삭제가 완료되었습니다." + "\n");
				bw.flush();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			strPrinter.notWriter();
			return;
		}
	}
}
