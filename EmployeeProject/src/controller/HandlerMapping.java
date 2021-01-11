package controller;

//싱글톤 패턴 적용
public class HandlerMapping {

	private static HandlerMapping instance = new HandlerMapping(); // 이게 싱글톤패턴(static,instance)

	private HandlerMapping() {

	}

	public static HandlerMapping getinstance() {
		if (instance == null)
			instance = new HandlerMapping(); // instance가 널일때만 handlermapping이 생성
		return instance;
	}

	public Controller createController(String command) {
		Controller controller = null;
		switch(command) {
		case "register":
			controller = new InsertEmployeeController();
			break;
		case "search": 
			controller = new SelectEmployeeController();
			break;
		case "update":
			controller = new UpdateEmployeeController();
			break;
		case "delete":
			controller = new DeleteEmployeeController();
			break;
		case "all":
			controller = new SelectAllEmployeeController();
			break;
		case "exit":
			break;
			
		}

		return controller;
	}

}
