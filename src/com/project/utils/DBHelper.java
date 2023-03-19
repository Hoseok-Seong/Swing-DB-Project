package com.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_DATABASE_NAME = "myshop";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "1234";

	private Connection conn;

	public DBHelper() {

	}

	private static DBHelper dbHelper;

	public static DBHelper getinstance() {
		if (dbHelper == null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}

	public Connection getConnection() {
		if (conn == null) {
			String userFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(userFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CHARSET);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">> DB 연결 완료 되었습니다. <<");
			} catch (Exception e) {
				System.out.println(" >> DBHelper에서 오류 발생했습니다. <<");
				e.printStackTrace();
			}
		}
		return conn;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}
}
