package config;

public interface DBConfig {
	// ����̹� Ŭ����
	public static final String DB_DRIVER = "oracle.jdbc.OracleDriver";
	// ���Ӱ��
	public static final String DB_URL = "jdbc:oracle:thin:@192.168.1.101:1521:xe";
	// ���̵�
	public static final String DB_USER = "scott";
	// ���
	public static final String DB_PASSWD = "tiger";
}
