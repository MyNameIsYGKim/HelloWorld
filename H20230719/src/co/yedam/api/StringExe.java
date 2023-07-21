package co.yedam.api;

public class StringExe {

	public static void main(String[] args) {
		String str = "Hello Wworld Nice";
		String[] strAry = str.split(" "); // 구분하는 문자 지정.
		int cnt = 0;
		for(String word : strAry) {
			System.out.println(word);
			if(word.indexOf("o") > -1) { // indexOf -> "?"가 포함된 문자
				cnt++;
			}
		}
		System.out.println("o 를 포함한 단어수: " + cnt);
	}

}
