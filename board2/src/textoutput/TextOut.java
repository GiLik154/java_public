package textoutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import boardfunction.BoardInfo;

public class TextOut {
	File file = new File("D:\\board\\board.txt");

	public void outputText(List<BoardInfo> list) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			for (BoardInfo i : list) {
				BoardInfo boardInfo = (BoardInfo) i;
				bw.write(boardInfo.num + ",");
				bw.write(boardInfo.title + ",");
				bw.write(boardInfo.content + ",");
				bw.write(boardInfo.writer + ",");
				bw.write(boardInfo.hits + ",");
				bw.write(boardInfo.date + "\n");
				bw.flush();
			}
			
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
