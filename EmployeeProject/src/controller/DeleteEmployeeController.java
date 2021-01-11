package controller;

import javax.swing.JOptionPane;

import dao.EmployeeDAO;
import vo.EmployeeVO;

public class DeleteEmployeeController implements Controller {

	@Override
	public void execute() {
		// 사번
		String eno = JOptionPane.showInputDialog("삭제할 사번 입력");
		// 이름
		String name = JOptionPane.showInputDialog("직원 이름 입력");
		// 부서
		String department = JOptionPane.showInputDialog("부서 입력");
		// 직급
		String posList = "1 - 사원\n2 - 주임\n3 - 대리\n4 - 과장\n" + "5 - 차장\n 6 - 부장\n7 - 사장";
		int position = Integer.parseInt(JOptionPane.showInputDialog(posList));
		EmployeeVO vo = new EmployeeVO(eno, name, department, position);
		EmployeeDAO.getInstance().deleteEmplopyee(vo);

	}

}
