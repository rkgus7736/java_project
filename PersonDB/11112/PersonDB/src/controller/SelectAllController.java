package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.PersonService;
import vo.PersonVO;

public class SelectAllController implements Controller {

	@Override
	public void execute(Scanner sc) {
		try {
			ArrayList<PersonVO> list = 
					PersonService.getInstance().selectAllPerson();
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
