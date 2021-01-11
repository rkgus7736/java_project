package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static DBManager instance = new DBManager();
	private Connection conn;

	public DBManager() {
		// DB접속을 하고 connection을 하나 초기화
		try {
			Class.forName(DBConfig.DB_DRIVER);
			try {
				conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USER, DBConfig.DB_PASS);
			    //auto commit 비활성화
				conn.setAutoCommit(false);
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static DBManager getInstance() {
		if (instance == null)
			instance = new DBManager();
		return instance;
	}

	public Connection getConnection() {
		return conn;
	}
}
