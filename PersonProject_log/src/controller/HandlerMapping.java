package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		if(instance==null)
			instance = new HandlerMapping();
		return instance;
	}
	//PersonManageSystem에서 해야되는 일을 진행할 클래스를 생성
	public Controller createController(int no) {
		Controller controller = null;
		switch(no) {
		case 1:
			controller = new InsertPersonController();
			break;
		case 2:
			controller = new DeletePersonController();
			break;
		case 3:
			controller = new UpdatePersonController();
			break;
		case 4:
			controller = new SelectPersonController();
			break;
		case 5:
			controller = new SelectAllPersonController();
			break;
		case 6:
			controller = new TestController();
			break;
		}
		return controller;
	}
	






}
