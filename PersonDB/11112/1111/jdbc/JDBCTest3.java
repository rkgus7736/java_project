package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest3 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//2. DB 접속
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.101:1521:xe","scott" ,"tiger" );
			//데이터 입력
			Scanner sc = new Scanner(System.in);
			System.out.print("사번 :");
			int no = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 :");
			String name = sc.nextLine();
			System.out.print("직급 :");
			String position=sc.nextLine();
			System.out.print("부서 :");
			String department=sc.nextLine();
			System.out.print("연봉 :");
			int salary = sc.nextInt();
			String sql = "insert into employee values(?,?,?,?,?)";
			//3. PreparedStatment 생성
			stmt = conn.prepareStatement(sql);
			//3-1.?에 데이터 셋팅
			stmt.setInt(1, no);
			stmt.setString(2, name);
			stmt.setString(3, position);
			stmt.setString(4, department);
			stmt.setInt(5, salary);
			//4. sql 실행
			int count = stmt.executeUpdate();
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



