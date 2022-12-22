package board.write;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BoardContents {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public String scanContents() {
		String contents = "";
		try {
			bw.write("내용을 입력해 주세요" + "\n");
			bw.flush();
			contents = br.readLine();
			bw.write(contents + " 내용이 입력되었습니다.");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contents;
	}

}

