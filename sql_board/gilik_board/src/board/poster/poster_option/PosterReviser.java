package board.poster.poster_option;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.poster.poster_utility.LastPost;
import board.poster.poster_utility.PostScaner;
import board.util.utility.StrPrinter;
import board.util.utility.WriterComparer;
import board.util.write.BoardContents;
import board.util.write.BoardTitle;
import site.util.utility.Constants;

public class PosterReviser {

	private static int EXIT = 0;
	private static int MISS_POST = -1;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	StrPrinter strPrinter = new StrPrinter();
	BoardTitle boardTitle = new BoardTitle();
	BoardContents boardContents = new BoardContents();
	LastPost lastPost = new LastPost();
	PostScaner postScaner = new PostScaner();
	WriterComparer writerComparer = new WriterComparer();

	Statement st = null;
	ResultSet result = null;

	public void run(Statement st, String id) {
		this.st = st;
		while (true) {

			try {
				bw.write("게시물을 수정합니다." + "\n");
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

			int postNumber = postScaner.scan(st);

			if (postNumber == EXIT) {
				strPrinter.exit();
				return;
			} else if (postNumber == MISS_POST) {
				strPrinter.missPost();
			} else {
				compareId(id, postNumber);
			}
		}
	}

	void compareId(String id, int postNumber) {
		if (writerComparer.run(st, "post", id, postNumber)) {
			int reviseOption = scanOption();
			splitOption(reviseOption, postNumber);
		} else {
			strPrinter.notWriter();
			return;
		}
	}

	private int scanOption() {
		int reviseOption = 0;
		while (true) {
			try {
				bw.write("어느것을 수정하시나요?" + "\n");
				bw.write("1. 제목 \\ 2. 내용 \\ 0. 종료" + "\n");
				bw.flush();

				reviseOption = Integer.parseInt(br.readLine());

				if (reviseOption == EXIT) {
					return EXIT;
				} else {
					return reviseOption;
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				strPrinter.checkInput();
			}
		}
	}

	private void splitOption(int reviseOption, int postNumber) {
		while (true) {

			switch (reviseOption) {
			case 1: // 제목 수정
				reviseTitle(postNumber);
				return;

			case 2: // 내용 수정
				reviseContents(postNumber);
				return;

			case 0: // 종료
				strPrinter.exit();
				return;
			default:
				strPrinter.checkInput();
				break;
			}
		}
	}

	private void reviseTitle(int postNumber) {
		try {
			bw.write("제목을 수정합니다.");
			bw.flush();
			String newTitle = boardTitle.scanTitle();
			st.executeUpdate("update  " + Constants.BOARD_TABLE_NAME + " set b_title ='" + newTitle + "'where b_num='"
					+ postNumber + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void reviseContents(int postNumber) {
		try {
			bw.write("내용을 수정합니다.");
			bw.flush();
			String newContents = boardContents.scanContents();
			st.executeUpdate("update  " + Constants.BOARD_TABLE_NAME + " set b_contents ='" + newContents
					+ "'where b_num='" + postNumber + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}