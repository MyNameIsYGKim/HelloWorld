package sec01.exam20;

public class StringTrimExample {

	public static void main(String[] args) {
		
		String s1 = "  02";
		String s2 = "123   ";
		String s3 = "    1234   ";
		
		System.out.println(s1.trim());
		System.out.println(s2.trim());
		System.out.println(s3.trim());
		System.out.println(s1.trim()+s2.trim()+s3.trim());
	}

}
