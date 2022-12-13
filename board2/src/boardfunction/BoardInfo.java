package boardfunction;

import java.time.LocalDate;

public class BoardInfo {
	LocalDate now = LocalDate.now();

	public int num;
	public int hits;
	public String title;
	public String content;
	public String writer;
	public String date = now.toString();

	public void recive(BoardWrite write) {
		this.num = write.num; // 리스트에서 add 처리
		this.title = write.title;
		this.content = write.content;
		this.writer = write.writer;
	}

	public void splitText(int num, String title, String content, String writer, String hits, String date) {
		this.num = num; // 텍스트 파일에서 불러오는 것 처리
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hits = Integer.parseInt(hits);
		this.date = date;
	}
}
