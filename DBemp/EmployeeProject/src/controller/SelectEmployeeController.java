package controller;



import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.EmployeeDAO;
import vo.EmployeeVO;

//리스트 사용해서 이름으로 검색
public class SelectEmployeeController implements Controller {
private ArrayList<EmployeeVO> list;
	@Override
	public void execute() {
		String name = JOptionPane.showInputDialog("검색할 사원명을 입력하세요");
		ArrayList<EmployeeVO> list = EmployeeDAO.getInstance().selectNameEmplopyee(name);
		 
		 for(int i =0; i<list.size();i++) {
			 System.out.println(list.get(i));
		
		
		
		
		
		}
	}

}