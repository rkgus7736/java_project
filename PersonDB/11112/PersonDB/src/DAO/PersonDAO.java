package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import vo.PersonVO;
/**
 * ResultSet,{@link PreparedStatement} Close
 * @param rs close할 ResultSet
 * @param pstmt colse 할 PreparedStatement
 */
//싱글톤
public class PersonDAO {
	private static PersonDAO instance = new PersonDAO();
	// DBManager 필드 선언 후 초기화
	private DBManager manager;

	private PersonDAO() {
		manager = DBManager.getInstance();
	}

	public static PersonDAO getInstance() {
		if (instance == null)
			instance = new PersonDAO();
		return instance;
	}

	// close
	public void close(ResultSet rs, PreparedStatement pstmt) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/**
 *전체 person 정보 조회 
 * @return ArrayList 로 PersonVO 리턴
 * @throws Exception 데이터 하나도 없는 경우
 */
	// 전체조회
	public ArrayList<PersonVO> selectAllPerson() throws Exception {
		ArrayList<PersonVO> list = new ArrayList<PersonVO>();
		// person 테이블에있는 모든 정보를 조회
		// -------------
		// Connection Load
		Connection conn = manager.getConnection();
		// SQL 문 작성 person - name age
		String sql = "select * from person";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new PersonVO(rs.getString(1), rs.getInt(2)));
			}
			if (list.isEmpty())
				throw new Exception("데이터가 한건도 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		// --------------
		return list;
	}

	// 회원 이름으로 검색 - ArrayList
	public ArrayList<PersonVO> selectPerson(String name) {
		ArrayList<PersonVO> list = new ArrayList<PersonVO>();
		Connection conn = manager.getConnection();
		String sql = "select * from person where name like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new PersonVO(rs.getString(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}

		return list;
	}

	// Person 추가 - insert into person(name, age) values(?,?)
	public void insertPerson(PersonVO p) throws Exception {
		Connection conn = manager.getConnection();
		String sql = "insert into person(name, age) values(?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getAge());
			int count = pstmt.executeUpdate();
			// int count () 안에 sql 넣으면 안됨
			if (count == 0)
				throw new Exception("데이터 등록에 실패했습니다.");
			System.out.println("데이터 등록에 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt);
		}
	}

	public void deletePerson(String name) throws Exception {
		Connection conn = manager.getConnection();
		String sql = "delete from person where name like ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			int count = pstmt.executeUpdate();
			if (count == 0)
				throw new Exception("삭제된 데이터가 없습니다.");
			System.out.println("삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// update person set name=?, age=? where name like ?
	public void updatePerson(String name, PersonVO vo) throws Exception {
// String name -> 검색한 정보 , PersonVO vo ->바꿀 데이터
		Connection conn = manager.getConnection();
		String sql = "update person set name=?, age=? where name like ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, name);

			int count = pstmt.executeUpdate();
			if (count == 0)
				throw new Exception("수정된 데이터가 없습니다.");
			System.out.println("데이터 수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt);
		}

	}
}
