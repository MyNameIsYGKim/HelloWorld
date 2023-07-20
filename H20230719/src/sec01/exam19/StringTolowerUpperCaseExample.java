package sec01.exam19;

public class StringTolowerUpperCaseExample {

	public static void main(String[] args) {
		
		String s1 = "Java Programming";
		String s2 = "JAVA Programming";
		String s3 = "java programming";
		
		System.out.println(s1.equals(s2)); // 내용이 같아도 대소문자 다르면 false.
		
		String lowerS1 = s1.toLowerCase();
		String lowerS2 = s2.toLowerCase();
		System.out.println(lowerS1.equals(lowerS2)); // 대소문자 동일함.
		
		System.out.println(s1.equalsIgnoreCase(s2)); // equalseIgnoreCase -> 대소문자 무시하고 내용 비교.
		
		System.out.println("--------------------------------------");
		String secondLower = s2.substring(0, 1) + s2.substring(1).toLowerCase();
		String firstUpper = s3.substring(0,1).toUpperCase() + s3.substring(1);
		System.out.println(secondLower);
		System.out.println(firstUpper);
	}

}
