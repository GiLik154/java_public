package boardfunction;

import java.io.*;

public class BoardWrite {
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String title;
	String content;
	String writer;
	int num = 0;

	public void reciveNum(int num) { // 텍스트에서 불러온 이후 번호 이어받음.
		this.num = num;
	}

	public void write() { // 메인 메소드. 이걸로 실행됨.
		try {
			num++;
			writeTitle();
			writeContent();
			writeWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void writeTitle() { // 제목 입력
		try {
			bw.write("제목을 입력하세요");
			bw.flush();
			title = br.readLine();
			bw.write("제목 : " + title + "\n");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void writeContent() { // 내용 입력
		try {
			bw.write("내용을 입력하세요");
			bw.flush();
			content = br.readLine();
			bw.write("내용 : " + content + "\n");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void writeWriter() { // 작성자 입력.
		try {
			bw.write("작성자을 입력하세요");
			bw.flush();
			writer = br.readLine();
			bw.write("작성자 : " + writer + "\n");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
