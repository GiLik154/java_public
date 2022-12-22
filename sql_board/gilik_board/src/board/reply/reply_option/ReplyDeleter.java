package board.reply.reply_option;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.poster.poster_utility.LastPost;
import board.reply.reply_utility.ReplyScaner;
import board.util.utility.StrPrinter;
import board.util.utility.WriterComparer;
import site.util.utility.Constants;
import site.util.utility.ConstantsReply;

public class ReplyDeleter {

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

			bw.write("삭제할 번호를 입력하세요. \\ 0. 취소" + "\n");
			bw.flush();

			int replyNumber = replyScaner.scan(st);

			if (replyNumber == Constants.EXIT) {
				strPrinter.exit();
			} else {
				compareId(id, replyNumber);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void compareId(String id, int replyNumber) throws IOException {
		try {
			if (writerComparer.run(st, "reply", replyNumber, id)) {
				st.executeUpdate("delete from " + Constants.REPLY_TABLE_NAME + " where " + ConstantsReply.B_REPLY_NUM
						+ " =" + replyNumber + ";");
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
