package controller;

import java.util.Scanner;

import service.StudentService;

public class SelectAllStduetnController implements Controller {
	@Override
	public void execute(Scanner sc) {
		StudentService.getInstance().selectAllStudent();
	}
}
