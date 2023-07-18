package co.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student(); // heap 영역에 인스턴스 생성.
		s1.stdName = "홍길동";
		
		Student s2 = new Student(); // 기본생성자를 이용한 인스턴스.
		s2.stdName = "홍길동";
		s2.stdNo = "23-0002";
		
		// 전체 필드를 초기화하는 생성자.
		Student s3 = new Student("23-0001", "홍길동", 80, 176.7);
		System.out.println(s3.showInfo());
		
		System.out.println(s1);
		System.out.println(s2);
		
		// 주소값은 항상 다름.
		// 필드의 값은 메소드를 통해 비교.
		System.out.println(s1.stdName.equals(s2.stdName)); 
	}
}
