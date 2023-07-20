package co.yedam.api;

public class ObjectExe1 {

	public static void main(String[] args) {
		
		String[] numbers = { "9802031234567", "0502033234567",
				"980203-1234567", "980203-2234567",
				"020203 1234567", "030203 2234567" };
		// 주민번호 뒷자리의 첫번째 값(성별: 1,3 남자/ 2,4 여자)
		for (String num : numbers) {
			System.out.println(num + " 의 성별: " + checkGender(num));
		}
	}
	
	static String checkGender(String no) {
		
		if(no.substring(6,7).equals("-")) { // 중간에 "-" 나 " " 제거.
			no = no.replace("-", "");
		}else if(no.substring(6,7).equals(" ")) {
			no = no.replace(" ", "");
		}
		
		if(no.substring(6,7).equals("1") || no.substring(6,7).equals("3")) {
			return "남자";
		}else if(no.substring(6,7).equals("2") || no.substring(6,7).equals("4")) {
			return "여자";
		}else {
			return "잘못된 주민등록번호";
		}
	}
 
}
