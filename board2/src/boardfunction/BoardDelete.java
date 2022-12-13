package boardfunction;

import java.io.*;
import java.util.List;

public class BoardDelete {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int selectBoard = 0;
    int num = 0;

    public void select() {
        try {
            selectBoard = 0;
            bw.write("몇 번 글을 삭제하시나요?" + "\n" + "\n");
            bw.flush();
            selectBoard = Integer.parseInt(br.readLine()) - 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeBoard(List<BoardInfo> list) {
        select();

        num = 0; // num 초기화
        boolean check = false; // check 초기화
        for (BoardInfo i : list) {
            num += 1; // 위치 찾기
            if (selectBoard == i.num - 1) {
                check = true;
                break;
            }
        }

        try {
            if (check) {
                list.remove(num - 1); // 0부터 시작하기 때문에 -1
                bw.write(selectBoard + 1 + "번호가 삭제되었습니다." + "\n" + "\n");
                bw.write("===================================================================================" + "\n");
                bw.flush();
            } else {
                bw.write("없는 게시물입니다" + "\n");
                bw.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
