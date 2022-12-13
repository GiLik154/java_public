package boardfunction;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;

public class BoardList {
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public void output(List<BoardInfo> list) {
		try {
			for (BoardInfo i : list) { // 향상된 for문
				BoardInfo boardInfo = (BoardInfo) i; // 형변환
				bw.write("글 번호 : " + boardInfo.num); // 출력
				bw.write(" || 글 제목 : " + boardInfo.title);
				bw.write(" || 글 작성자 : " + boardInfo.writer);
				bw.write(" || 글 조회수 : " + boardInfo.hits);
				bw.write(" || 글 작성일 : " + boardInfo.date + "\n");
			}
			bw.write("================================================================================================="
					+ "\n");
			bw.flush();
		} catch (Exception e) { // 예외처리
			e.printStackTrace();
		}
	}
}
