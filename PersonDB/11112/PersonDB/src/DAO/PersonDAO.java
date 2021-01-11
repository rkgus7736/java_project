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
 * @param rs close�� ResultSet
 * @param pstmt colse �� PreparedStatement
 */
//�̱���
public class PersonDAO {
	private static PersonDAO instance = new PersonDAO();
	// DBManager �ʵ� ���� �� �ʱ�ȭ
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
 *��ü person ���� ��ȸ 
 * @return ArrayList �� PersonVO ����
 * @throws Exception ������ �ϳ��� ���� ���
 */
	// ��ü��ȸ
	public ArrayList<PersonVO> selectAllPerson() throws Exception {
		ArrayList<PersonVO> list = new ArrayList<PersonVO>();
		// person ���̺��ִ� ��� ������ ��ȸ
		// -------------
		// Connection Load
		Connection conn = manager.getConnection();
		// SQL �� �ۼ� person - name age
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
				throw new Exception("�����Ͱ� �Ѱǵ� �����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		// --------------
		return list;
	}

	// ȸ�� �̸����� �˻� - ArrayList
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

	// Person �߰� - insert into person(name, age) values(?,?)
	public void insertPerson(PersonVO p) throws Exception {
		Connection conn = manager.getConnection();
		String sql = "insert into person(name, age) values(?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getAge());
			int count = pstmt.executeUpdate();
			// int count () �ȿ� sql ������ �ȵ�
			if (count == 0)
				throw new Exception("������ ��Ͽ� �����߽��ϴ�.");
			System.out.println("������ ��Ͽ� �����߽��ϴ�.");
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
				throw new Exception("������ �����Ͱ� �����ϴ�.");
			System.out.println("���� �Ϸ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// update person set name=?, age=? where name like ?
	public void updatePerson(String name, PersonVO vo) throws Exception {
// String name -> �˻��� ���� , PersonVO vo ->�ٲ� ������
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
				throw new Exception("������ �����Ͱ� �����ϴ�.");
			System.out.println("������ ���� �Ϸ�");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt);
		}

	}
}
