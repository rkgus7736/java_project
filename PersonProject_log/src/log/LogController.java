package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogController {

	private static LogController instance = new LogController();
	private FileWriter fw;
	private PrintWriter pw;

	private LogController() {
		try {
			fw = new FileWriter("log.txt", true);
			pw = new PrintWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static LogController getInstance() {
		if (instance == null)
			instance = new LogController();
		return instance;

	}

	private final String[] LOG_TAG = { "에러", "추가", "삭제", "조회", "수정" };
	// LOG_TAG 상수는 항상 대문자로
	public void writeLog(int no, String content) {
		LogData ld = new LogData(LOG_TAG[no], content);
		pw.println(ld.toString());
		pw.flush();

	}

	@Override
	protected void finalize() throws Throwable {
		if(pw != null) pw.close();
		System.out.println("로그 파일 연결 해제");
}
}