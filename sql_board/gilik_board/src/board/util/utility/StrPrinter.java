package board.util.utility;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class StrPrinter {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public void exit() {
		try {
			bw.write("종료합니다. \n" + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void checkInput() {
		try {
			bw.write("입력을 확인해주세요. \n" + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void missPost() {
		try {
			bw.write("입력하신 게시물이 없습니다. \n" + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void inputPost() {
		try {
			bw.write("글 번호를 입력해주세요. \\ 0. 종료 \n" + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void resultInput() {
		try {
			bw.write("입력이 완료되었습니다. \n" + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void notWriter() {
		try {
			bw.write("작성자가 아닙니다. \n");
			bw.write("글 번호를 확인해주세요. \n" + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
