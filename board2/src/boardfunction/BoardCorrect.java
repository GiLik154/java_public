package boardfunction;

import java.io.*;
import java.util.List;

public class BoardCorrect {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int selectBoard = 0;
    String selectMenu = "";
    int num = 0;
    boolean cheak = false;

    public void selectBoard() {
        try {
            selectBoard = 0;
            bw.write("몇 번 글을 수정하시나요?" + "\n" + "\n");
            bw.flush();
            selectBoard = Integer.parseInt(br.readLine()) - 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectMenu() {
        try {
            selectMenu = "";
            bw.write((selectBoard + 1) + "번 글을 수정합니다." + "\n" + "\n");
            bw.write("1.제목/2.내용/3.작성자/e.나가기" + "\n" + "\n");
            bw.flush();
            selectMenu = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void correnctBoard(List<BoardInfo> list) {
        selectBoard();

        num = 0; // num 초기화
        cheak = false; // cheak 초기화
        for (BoardInfo i : list) {
            num += 1; // 위치 찾기
            if (selectBoard == i.num - 1) {
                cheak = true;
                break;
            }
        }

        try {
            while (true) {
                if (cheak) {
                    selectMenu();
                    BoardInfo boardInfo = list.get(num - 1);
                    String str;
                    switch (selectMenu) {

                        case "1":
                            bw.write("제목을 수정합니다." + "\n");
                            bw.write("수정할 내용을 입력해주세요" + "\n" + "\n");
                            bw.flush();
                            str = br.readLine();
                            boardInfo.title = str;
                            break;

                        case "2":
                            bw.write("내용을 수정합니다." + "\n");
                            bw.write("수정할 내용을 입력해주세요" + "\n" + "\n");
                            bw.flush();
                            str = br.readLine();
                            boardInfo.content = str;
                            break;

                        case "3":
                            bw.write("작성자를 수정합니다." + "\n");
                            bw.write("수정할 내용을 입력해주세요" + "\n" + "\n");
                            bw.flush();
                            str = br.readLine();
                            boardInfo.writer = str;
                            break;

                        case "e":
                            bw.write("취소합니다." + "\n" + "\n");
                            bw.flush();
                            return;

                        default:
                            bw.write("입력을 확인해주세요." + "\n" + "\n");
                            bw.flush();
                            break;
                    }

                } else {
                    bw.write("없는 게시물입니다" + "\n");
                    bw.flush();
                    return;
                }
            }

        } catch (

                Exception e) {
            e.printStackTrace();
        }
    }

}
