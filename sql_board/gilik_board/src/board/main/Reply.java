package board.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Statement;

import board.reply.reply_option.ReplyDeleter;
import board.reply.reply_option.ReplyList;
import board.reply.reply_option.ReplyReader;
import board.reply.reply_option.ReplyReviser;
import board.reply.reply_option.ReplyWriter;
import board.util.utility.StrPrinter;

public class Reply {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StrPrinter strPrinter = new StrPrinter();
	ReplyWriter replyWriter = new ReplyWriter();
	ReplyList replyList = new ReplyList();
	ReplyReader replyReader = new ReplyReader();
	ReplyDeleter replyDeleter = new ReplyDeleter();
	ReplyReviser replyReviser = new ReplyReviser();

	void selctMenu(Statement st, String id) throws IOException {
		while (true) {
			bw.write("1.댓글 메뉴입니다." + "\n");
			bw.write("1.댓글 리스트 \\ 2. 댓글 보기 \\ 3. 댓글 쓰기 \\ 4. 댓글 삭제 \\ 5. 댓글 수정 \\ e. 프로그램 종료" + "\n");
			bw.flush();

			switch (br.readLine()) {
			case "1":
				replyList.run(st); // 댓글 리스트
				break;

			case "2":
				replyReader.run(st); // 댓글 보기
				break;

			case "3":
				replyWriter.run(st, id); // 댓글 쓰기
				break;

			case "4":
				replyDeleter.delet(st, id); //댓글 삭제
				break;

			case "5":
				replyReviser.run(st, id); // 댓글 수정
				break;

			case "e":
				strPrinter.exit(); //프로그램 종료
				return;

			default:
				strPrinter.checkInput();
				break;
			}
		}
	}
}
