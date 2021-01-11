package controller;

import java.util.Scanner;

import service.PersonManageSystem;

public class SelectAllPersonController extends Controller {
	@Override
	public void execute(Scanner sc) {
		PersonManageSystem.getInstance().selectAllPerson();
	}
}
