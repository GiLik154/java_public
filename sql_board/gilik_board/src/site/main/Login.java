package site.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import site.util.utility.Constants;
import site.util.utility.ConstantsMember;

public class Login {
	Statement st = null;
	ResultSet result = null;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public String run(Statement st) {
		this.st = st;

		while (true) {
			String login = input();
			try {
				if (login != null) {
					bw.write("로그인에 성공하였습니다." + "\n");
					bw.flush();
					return login;
				} else {
					bw.write("로그인에 실패하였습니다.." + "\n\n");
					bw.flush();
					return null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String input() {
		String id = "";
		try {
			bw.write("아이디를 입력하세요 \\ 0. 뒤로가기");
			bw.flush();
			id = br.readLine();

			if (id.equals("0")) {
				bw.write("뒤로 돌아갑니다." + "\n");
				return null;
			}

			bw.write("비밀번호를 입력하세요");
			bw.flush();
			String inputPassword = br.readLine();

			String getPassword = getPassword(id);

			if (inputPassword.equals(getPassword)) {
				return id;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getPassword(String id) {
		String password = null;
		try {
			result = st.executeQuery(
					"select * from " + Constants.MEMBER_TABLE_NAME + " where " + ConstantsMember.ID + " = " + id + ";");

			if (result.next()) {
				password = result.getString("password");
			}

			if (password == null) {
				return null;
			}

		} catch (SQLException e) {
		}
		return password;
	}

}