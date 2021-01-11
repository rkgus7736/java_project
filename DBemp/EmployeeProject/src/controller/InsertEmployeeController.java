package controller;

import javax.swing.JOptionPane;

import dao.EmployeeDAO;
import vo.EmployeeVO;

public class InsertEmployeeController implements Controller {

	@Override
	public void execute() {
		// 내용입력
		// 사번
		String eno = JOptionPane.showInputDialog("사번입력");
		// 이름
		String name = JOptionPane.showInputDialog("직원 이름입력");
		// 부서
		String department = JOptionPane.showInputDialog("직원 부서입력");
		// 직급
		String Poslist = "1-사원\n2-주임\n3-대리\n4-과장\n5-차장\n6-부장\n7-사장";
		int position = Integer.parseInt(JOptionPane.showInputDialog("직원 직급입력"));
		EmployeeVO vo = new EmployeeVO(eno, name, department, position);
		EmployeeDAO.getInstance().insertEmployee(vo);
	}

}
