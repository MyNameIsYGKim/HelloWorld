package sec01.exam15;

public class StringIndexOfExample {

	public static void main(String[] args) {
		
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍"); // 첫번째가 0, 첫글자의 위치 찾음.
		System.out.println(location);			   // 찾는 문자열이 없으면 -1 리턴.
		
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책이다.");
		}else {
			System.out.println("자바와 관련없는 책이다.");
		}
	}

}
