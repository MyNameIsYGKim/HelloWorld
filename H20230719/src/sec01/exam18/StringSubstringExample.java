package sec01.exam18;

public class StringSubstringExample {

	public static void main(String[] args) {
		
		String s = "123456-7897897";
		
		String first = s.substring(0 , 6); // (위치1, 위치2) - 위치1 부터 위치2 까지
		String second = s.substring(7); // (위치) - 위치부터 뒤에 전부
		
		System.out.println(first);
		System.out.println(second);
	}

}
