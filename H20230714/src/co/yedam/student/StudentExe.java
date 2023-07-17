package co.yedam.student;

public class StudentExe {

	public static void main(String[] args) {
		// 학생번호, 학생이름, 점수.
		Student std1 = new Student(); // 인스턴스.
		std1.setStudentNo(100);
		std1.setStudentName("홍길동");
		std1.setScore(80);
		
//		System.out.println(std1.studentName);
		
		Student std2 = new Student();
		std2.setStudentNo(110);
		std2.setStudentName("김길동");
		std2.setScore(85);
		
		Student[] students = {std1, std2};
		students = new Student[5];
		students[0] = std1;
		students[1] = std2;
		
		// 120 박길동 90점 => std3
		Student std3 = new Student();
		std3.setStudentNo(120);
		std3.setStudentName("박길동");
		std3.setScore(90);
		
		students[2] = std3;
		
		String searchName = "홍길동";
		// 최고점수를 받은 학생의 정보 출력.
		int maxScore = 0;
		// 평균점수
		int sum = 0, count = 0;
		double avg = 0;
		// max값을 학생의 정보 담기 위한 Student.
		Student maxStd = new Student();
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				// 4, 5번째 null
//				if(students[i].studentName.equals(searchName)) {
//					System.out.printf("학생번호: %d, 이름: %s, 점수: %d",
//							students[i].studentNo,students[i].studentName,students[i].score);
//				}
				// 최고점수 학생의 정보.
				if (students[i].getScore() > maxScore) {
					maxScore = students[i].getScore();
					maxStd = students[i];
				}
				sum += students[i].getScore();
				count += 1;
			}
		}
		avg = (double) sum/count;
		
		System.out.printf("학생번호: %d, 이름: %s, 점수: %d",
			maxStd.getStudentNo(), maxStd.getStudentName(), maxStd.getScore());
		System.out.printf("\n합계점수: %d, 평균: %.1f", sum, avg);
	} // end of main.

}
