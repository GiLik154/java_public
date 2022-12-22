package site.main;

import java.sql.Statement;

import site.util.utility.ConnectSQL;

public class SiteMain {
	public static void main(String[] args) {

		ConnectSQL connectSQL = new ConnectSQL();
		Statement st = connectSQL.run();

		Menu menu = new Menu();
		menu.run(st);
	}

}
