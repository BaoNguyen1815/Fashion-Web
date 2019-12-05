package com.fashion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public static void main(String[] args) {
		JDBCConnection jdbcConnection = new JDBCConnection();

		Connection con = jdbcConnection.getConnection();
		if (con == null) {
			System.out.println("That bai");
		} else {
			System.out.println("Thanh cong");
		}
	}

	public Connection getConnection() {
		try {
			final String username = "root";
			final String password = "root";
			final String url = "jdbc:mysql://localhost:3306/fashion";

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(url, username, password);

			return conn;
		} catch (Exception ex) {
			System.out.println("Loi ket noi");
			System.out.println(ex);
		}
		return null;
	}
}
