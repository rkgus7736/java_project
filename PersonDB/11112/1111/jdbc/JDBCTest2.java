package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//2. DB 접속
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.101:1521:xe","scott" ,"tiger" );
			//3. statment 생성
			stmt = conn.createStatement();
			//4. Sql 작성 및 실행
			String sql = "insert into employee "
					+ "values(28,'테스트','인턴','인사팀',2000)";
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}



