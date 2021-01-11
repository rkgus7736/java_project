package controller;

//싱글톤
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		if (instance == null)
			instance = new HandlerMapping();
		return instance;
	}

	public Controller createController(int no) {
		Controller controller = null;
		switch (no) {
		case 1:
			controller = new InsertController();
			break;
		case 2:
			controller = new SelectController();
			break;
		case 3:
			controller = new DeleteController();
			break;
		case 4:
			controller = new UpdateController();
			break;
		case 5:
			controller = new SelectAllController();
			break;
		}
		return controller;
	}

}
