package co.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ChracterConvertStreamExe {
	public static void main(String[] args) {
		try {
			write("문자열보조 스트림 테스트");
			String str = read();
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void write(String str) throws Exception {
		// 바이트 기반 스트림. -> 문자열 기반 스트림 변경 보조 스트림.
		FileOutputStream fos = new FileOutputStream("c:/Temp/text.txt");
		Writer writer = new OutputStreamWriter(fos);
		writer.write(str);
		writer.flush();
		writer.close();
	}
	
	public static String read() throws Exception {
		FileInputStream fis = new FileInputStream("c:/Temp/text.txt");
		Reader reader = new InputStreamReader(fis);
		char[] buf = new char[100]; // 문자:34개
		int chrNum = reader.read(buf); // 파일의 끝: -1, 읽어들인 문자크기.
		System.out.println("chrNum: " + chrNum);
		String data = new String(buf, 0, chrNum);
		fis.close();
		reader.close();
		return data;
	}
}
