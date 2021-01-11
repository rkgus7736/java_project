package log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogData {

	private String kind;
	private Calendar calendar;
	private String content;

	public LogData(String kind, String content) {
		super();
		this.kind = kind;
		this.calendar = Calendar.getInstance();
		this.content = content;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		String log = kind + "\t" + sdf.format(calendar.getTime())+ "\t" + content;

		return log;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
