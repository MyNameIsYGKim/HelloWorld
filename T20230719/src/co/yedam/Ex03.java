package co.yedam;

public class Ex03 {
	public static void main(String[] args) {
		int[] numArr = new int[5];
		
		int min = 0;
		int max = 0;
		
		for(int i=0; i<5; i++) { // 1~10 랜덤배열 생성.
			numArr[i] = (int)Math.floor(Math.random()*10 + 1);
			System.out.println(numArr[i]);
		}
		
		max = numArr[0];
		min = numArr[0];
		for(int i=0; i<numArr.length; i++) {
			if(numArr[i] >= max) {
				max = numArr[i];
			}
			if(numArr[i] <= min) {
				min = numArr[i];
			}
		}
		System.out.println("최솟값: "+min);
		System.out.println("최댓값: "+max);
	}
}
