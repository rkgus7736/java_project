package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest1 {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs= null;
		Statement stmt= null;
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//2. DB접속
			String url = "jdbc:oracle:thin:@192.168.1.101:1521:xe";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password);
			//3. 조회
			String sql = "select * from employee "
					+ "where salary >= 4000 and department = '총무팀'";
			// 연봉 4천이상 총무팀 사원
                                     stmt = conn.createStatement();
			//4. 결과 조회
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(
						rs.getInt("emp_no")+"\t"+
						rs.getString("name")+"\t"+
						rs.getString("position")+"\t"+
						rs.getString("department")+"\t"+
						rs.getInt("salary")
						);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5. close
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}


