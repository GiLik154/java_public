package board.write;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BoardWriter {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public String scanWriter() {
		String writer = "";
		try {
			bw.write("작성자를 입력해 주세요" + "\n");
			bw.flush();
			writer = br.readLine();
			bw.write(writer + " 작성자가 입력되었습니다.");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer;
	}

}
