package board.reply_option;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.poster_utility.LastPost;
import board.reply_utility.ReplyScaner;
import board.utility.StrPrinter;
import board.utility.WriterComparer;
import site.utility.Constants;

public class ReplyDeleter {

	private static int EXIT = 0;
	private static int MISS_POST = -1;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	LastPost lastPost = new LastPost();
	StrPrinter strPrinter = new StrPrinter();
	ReplyScaner replyScaner = new ReplyScaner();
	WriterComparer writerComparer = new WriterComparer();

	Statement st = null;
	Connection con = null;
	ResultSet result = null;

	public void delet(Statement st, String id) {
		this.st = st;
		try {

			bw.write("삭제할 번호를 입력하세요. \\ 0. 취소");
			bw.flush();

			int replyNumber = replyScaner.scan(st);

			if (replyNumber == EXIT) {
				strPrinter.exit();
			} else if (replyNumber == MISS_POST) {
				strPrinter.missPost();
			} else {
				compareId(id, replyNumber);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void compareId(String id, int replyNumber) throws IOException {
		try {
			if (writerComparer.run(st, "reply", id, replyNumber)) {
				st.executeUpdate(
						"delete from " + Constants.REPLY_TABLE_NAME + " where b_reply_num =" + replyNumber + ";");
				bw.write("삭제가 완료되었습니다." + "\n");
				bw.flush();
			} else {
				strPrinter.notWriter();
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
