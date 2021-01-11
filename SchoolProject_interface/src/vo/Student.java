package vo;

public class Student {
	//학번
	private String sno;
	//이름
	private String name;
	//전공
	private String major;
	//평점
	private double score;
	//생성자
	
	//setter getter 추가
	
	//초기화
	public void init(String s,String n, String m, double sc) {
		sno = s;
		name = n;
		major = m;
		score = sc;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Student(String sno, String name, String major, double score) {
		super();
		this.sno = sno;
		this.name = name;
		this.major = major;
		this.score = score;
	}
	//학생 정보 출력
	public void printStudentInfo() {
		System.out.println("학번 : "+sno);
		System.out.println("이름 : "+name);
		System.out.println("전공 : "+major);
		System.out.println("평점 : "+getGrade()+"("+score+")");
	}
	public String getGrade() {
		if(score == 4.5)
			return "A+";
		else if(score >= 4.0)
			return "A";
		else if(score >= 3.5)
			return "B+";
		else if(score >= 3.0)
			return "B";
		else if(score >= 2.5)
			return "C+";
		else if(score >= 2.0)
			return "C";
		else if(score >= 1.0)
			return "D";
		else
			return "F";
	}
}





