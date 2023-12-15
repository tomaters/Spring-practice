package com.mirae.board;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.jupiter.api.Test;

public class OracleConnectionTest {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "hr";
	private static final String PASS = "hr";

	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try (Connection conn = DriverManager.getConnection(URL, ID, PASS)) {
		System.out.println(conn);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}