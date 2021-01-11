package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBManager;

public class JDBCTest4 {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs= null;
		Statement stmt= null;
		try {
			conn = DBManager.getInstance().getConnection();
			//3. 조회
			String sql = "select * from employee ";
					//+ "where salary >= 4000 and department = '총무팀'";
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
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5. close
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}


