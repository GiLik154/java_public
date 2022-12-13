package boardfunction;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;

public class BoardList {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void output(List<BoardInfo> list) {
        try {
            for (BoardInfo i : list) { // 향상된 for문
                bw.write("글 번호 : " + i.num); // 출력
                bw.write(" || 글 제목 : " + i.title);
                bw.write(" || 글 작성자 : " + i.writer);
                bw.write(" || 글 조회수 : " + i.hits);
                bw.write(" || 글 작성일 : " + i.date + "\n");
            }
            bw.write("================================================================================================="
                    + "\n");
            bw.flush();
        } catch (Exception e) { // 예외처리
            e.printStackTrace();
        }
    }
}
