package site.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.sql.Statement;

import site.util.utility.StrPrinter;

public class Join {
	Statement st = null;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	StrPrinter strPrinter = new StrPrinter();

	public void run(Statement st) {
		this.st = st;
		try {
			bw.write("회원가입을 시작합니다." + "\n");
			bw.flush();
			complete();
			bw.write("회원가입이 완료되었습니다." + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void complete() {

		String id = id();
		String password = comparePass();
		String name = name();
		String age = age();
		String sex = sex();
		String phone = phone();
		String hobby = hobby();

		String makingboard = ("insert into member(id, password,  name, age, sex, phone, hobby) values ('" + id + "',"
				+ "'" + password + "','" + name + "'" + ",'" + age + "','" + sex + "','" + phone + "','" + hobby
				+ "');");
		System.out.println(makingboard);

		try {
			st.executeUpdate(makingboard);
			strPrinter.resultInput();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private String input(String state) {
		String input = "";
		try {
			bw.write(state + "(을)를 입력하세요.");
			bw.flush();
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	private String id() {
		String state = "아이디";
		String id = "";
		while (true) {
			id = input(state);
			if (id.length() < 3) {
				try {
					bw.write("아이디 길이가 짧습니다." + "\n");
					bw.write("다시 입력하세요." + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}
		return id;
	}

	private String password() {
		String state = "비밀번호";
		String password = "";
		while (true) {
			password = input(state);
			if (password.length() < 5) {
				try {
					bw.write("비밀번호 길이가 짧습니다." + "\n");
					bw.write("다시 입력하세요." + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}
		return password;
	}

	private String passCheak() {
		String passCheak = "";
		String state = "비밀번호 확인";
		while (true) {
			passCheak = input(state);
			if (passCheak.length() < 5) {
				try {
					bw.write("비밀번호 확인 길이가 짧습니다." + "\n");
					bw.write("다시 입력하세요." + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}
		return passCheak;
	}

	private String name() {
		String state = "이름";
		String name = input(state);
		return name;
	}

	private String age() {
		String state = "나이";
		String age = input(state);
		return age;
	}

	private String sex() {
		String state = "성별";
		String sex = input(state);
		return sex;
	}

	private String phone() {
		String state = "휴대폰 번호";
		String phone = input(state);
		return phone;
	}

	private String hobby() {
		String state = "취미";
		String hobby = input(state);
		return hobby;
	}

	private String comparePass() {
		while (true) {
			String password = password();
			String passCheak = passCheak();

			if (password.equals(passCheak)) {
				return password;
			} else {
				try {
					bw.write("비밀번호 확인이 일치하지 않습니다." + "\n");
					bw.write("다시 입력해주세요." + "\n");

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
