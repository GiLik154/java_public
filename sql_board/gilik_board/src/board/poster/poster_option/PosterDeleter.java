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

public class PosterDeleter {

	private static int EXIT = 0;
	private static int MISS_POST = -1;

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

				bw.write("글을 삭제합니다.");
				bw.flush();

				int postNumber = postScaner.scan(st);

				if (postNumber == EXIT) {
					strPrinter.exit();
					return;
				} else if (postNumber == MISS_POST) {
					strPrinter.missPost();
				} else {
					compareId(id, postNumber);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void compareId(String id, int postNumber) throws IOException {
		if (writerComparer.run(st, "post", id, postNumber)) {
			try {
				st.executeUpdate("delete from " + Constants.BOARD_TABLE_NAME + " where b_num =" + postNumber + ";");
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
