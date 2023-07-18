package co.yedam.student;

public class Student {
	// 필드.
	String stdNo; // 
	String stdName;
	int score;
	double height;
	
	// 생성자.
	// 생성자 오버로딩.
	Student() {
		
	}
	Student(String stdNo) {
		this.stdNo = stdNo; // 필드의 초기값 지정.
	}
	
	Student(String stdNo, int score) {
//		this.stdNo = stdNo;
		this(stdNo); // this 클래스에서 자기자신의 필드, 생성자, 메소드.
		this.score = score;
	}
	
	public Student(String stdNo, String stdName, int score, double height) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.score = score;
		this.height = height;
	}
	
	public Student(String stdName, String stdNo, double height, int score) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.score = score;
		this.height = height;
	}
	
	// 메소드.
	public String showInfo() {
		return "학생번호: " + stdNo + ", 학생이름: " + stdName;
	}
}
