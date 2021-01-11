package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//�̱���
public class DBManager {
	public static DBManager instance = new DBManager();
	private Connection conn;

	private DBManager() {
		// ����̹� �ε�
		try {
			Class.forName(DBConfig.DB_DRIVER);
			// DB ����

			conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USER, DBConfig.DB_PASSWD);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

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
