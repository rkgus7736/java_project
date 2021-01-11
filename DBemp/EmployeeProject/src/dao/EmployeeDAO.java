package dao;
//싱글톤

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import config.DBManager;

import vo.EmployeeVO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private DBManager manager;

	public EmployeeDAO() {
		manager = DBManager.getInstance();
	}

	public static EmployeeDAO getInstance() {
		if (instance == null)
			instance = new EmployeeDAO();
		return instance;

	}

	public void insertEmployee(EmployeeVO vo) {
		Connection conn = manager.getConnection();
		String sql = "insert into employee values(?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEno());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getDepartment());
			pstmt.setInt(4, vo.getPosition());

			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("사원 등록 실패");
				conn.rollback();// DBManager에서 auto commit을 껐다면 써줘야함
				// (exception이 있다는건 오류가 있다는거라 catch에도 rollback을 써줘야함)
			} else
				System.out.println("사원 등록 성공");
			conn.commit(); // DBManager에서 auto commit을 껐다면 써줘야함

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public ArrayList<EmployeeVO> selectAllEmployee() {
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		Connection conn = manager.getConnection();
		String sql = "select * from employee";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new EmployeeVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return list;
	}

	public ArrayList<EmployeeVO> selectNameEmplopyee(String name) {
		Connection conn = manager.getConnection();
		name += "%" + name + "%"; // 와일드카드 양쪽에 붙이는 방법
		String sql = "select * from employee where name like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new EmployeeVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	public void updateEmplopyee(EmployeeVO vo) {
		Connection conn = manager.getConnection();
		String sql = "update employee set name=?,department=?,position=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, vo.getEno());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getDepartment());
			pstmt.setInt(3, vo.getPosition());

			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("사원정보 수정 실패");
				conn.rollback();// DBManager에서 auto commit을 껐다면 써줘야함
				// (exception이 있다는건 오류가 있다는거라 catch에도 rollback을 써줘야함)
			} else
				System.out.println("사원정보 수정 성공");
			conn.commit(); // DBManager에서 auto commit을 껐다면 써줘야함

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteEmplopyee(EmployeeVO vo) {
		Connection conn = manager.getConnection();
		String sql = "delete from employee where eno = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEno());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getDepartment());
			pstmt.setInt(4, vo.getPosition());

			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("사원 삭제 실패");
				conn.rollback();// DBManager에서 auto commit을 껐다면 써줘야함
				// (exception이 있다는건 오류가 있다는거라 catch에도 rollback을 써줘야함)
			} else
				System.out.println("사원 삭제 성공");
			conn.commit(); // DBManager에서 auto commit을 껐다면 써줘야함

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public HashMap<String, Integer> positionAvgSalary() { {
		Connection conn = manager.getConnection();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String sql = "SELECT EPOSITION, AVG(SALARY)" + " FROM EMPLOYEE GROUP BY EPOSITION";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// map.put(rs.getString(1),rs.getInt(2));
				//-->sql에서 미리 써주면 스위치문 없앨수있고 아래 문장들 안써도 됨. 캐치만 있으면됨
				int avg = rs.getInt(2);// 평균 연봉
				switch (rs.getInt(1)) {
				case 1:
					map.put("사원", avg);
					break;
				case 2:
					map.put("주임", avg);
					break;
				case 3:
					map.put("대리", avg);
					break;
				case 4:
					map.put("과장", avg);
					break;
				case 5:
					map.put("차장", avg);
					break;
				case 6:
					map.put("부장", avg);
					break;
				case 7:
					map.put("사장", avg);
					break;

				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	return null;
}
}