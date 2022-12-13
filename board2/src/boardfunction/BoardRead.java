package boardfunction;

import java.io.*;
import java.util.List;

public class BoardRead {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int selectBoard = 0;
	int num = 0;
	boolean cheak = false;

	public void select() {
		try {
			bw.write("몇 번 글을 읽으시나요?");
			bw.flush();
			selectBoard = Integer.parseInt(br.readLine()) - 1; // 0부터 시작이기에 -1
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void read(List<BoardInfo> list) {
		select();

		num = 0; // num 초기화
		cheak = false;
		for (BoardInfo i : list) {
			num += 1; // 위치 찾기
			if (selectBoard == i.num - 1) { // 글 번호 비교
				cheak = true; // 글 번호가 같으면 트루 출력
				break;
			}
		}

		try {
			if (cheak) { // 트루일 경우 아래의 입력 출력
				BoardInfo boardInfo = list.get(num - 1); // 0부터 시작하기 때문에 -1
				boardInfo.hits++; // 조회수 + 1;
				bw.write("글 번호 : " + boardInfo.num);
				bw.write(" || 글 제목 : " + boardInfo.title);
				bw.write(" || 글 작성자 : " + boardInfo.writer + "\n");
				bw.write("글 내용 : " + boardInfo.content + "\n");
				bw.write("글 조회 : " + boardInfo.hits);
				bw.write(" || 글 작성일 : " + boardInfo.date + "\n");
				bw.write(
						"================================================================================================="
								+ "\n");
				bw.flush();
			} else { // 번호가 없을 경우 출력
				bw.write("없는 게시물입니다" + "\n");
				bw.flush();
			}
		} catch (Exception e) { // 예외 처리
			e.printStackTrace();
		}
	}
}
