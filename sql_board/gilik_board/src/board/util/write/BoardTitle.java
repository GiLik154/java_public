package board.util.write;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BoardTitle {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public String scanTitle() {
		String title = "";
		try {
			bw.write("제목을 입력해 주세요" + "\n");
			bw.flush();
			title = br.readLine();
			bw.write(title + " 제목이 입력되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return title;
	}

}