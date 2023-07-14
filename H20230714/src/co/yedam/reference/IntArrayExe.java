package co.yedam.reference;

public class IntArrayExe {

	public static void main(String[] args) {
		int[] intAry = { 10, 20, 30 };
		intAry = new int[] { 10, 20, 30 }; // 정수형 배열 3개 크기.
		intAry = new int[5]; // 정수형 배열 공간 5개 크기.
		
		intAry[0] = 15;
		intAry[intAry.length - 1] = 55;
		System.out.println(intAry[intAry.length - 1]);
		int sum = 0;
		for(int i=0; i<intAry.length; i++) {
			System.out.println(intAry[i]);
			sum += intAry[i];
		}
		System.out.println("sum : "+sum);
		
		// 확장 for.
		for(int num : intAry) {
			System.out.println(num);
			sum += num;
		}
		System.out.println("sum : "+sum);
		
		// 정수를 저장할 수 있는 배열 scores.
		// 학생1 ~ 학생5: 80, 85, 77, 93, 100
		// 점수의 합과 평균.
		double student[] = {80, 85, 77, 93, 100};
		sum = 0;
		for(int i=1; i < student.length; i++ ) {
			sum += student[i];
		}
		double avg = sum/(double)student.length;
		System.out.println("==================");
		System.out.printf("점수합은 %d, 평균은 %.1f", sum, avg);
		
	} // end of main.

}
