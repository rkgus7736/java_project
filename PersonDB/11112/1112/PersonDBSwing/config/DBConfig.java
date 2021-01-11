package config;

public interface DBConfig {
	//드라이버 클래스
	public static final String DB_DRIVER = "oracle.jdbc.OracleDriver"; 
	//접속 경로
	public static final String DB_URL = "jdbc:oracle:thin:@192.168.1.101:1521:xe"; 
	//아이디
	public static final String DB_USER = "scott"; 
	//비번
	public static final String DB_PASSWD = "tiger"; 
}
