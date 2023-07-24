package co.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteBufExe {
	public static void main(String[] args) throws Exception {
		// 입력스트림
		InputStream is = new FileInputStream("c:/Temp/img2.jpg");
		OutputStream os = new FileOutputStream("c:/Temp/copy.jpg");
		System.out.println("start of prog.");
		byte[] buf = new byte[100];
		while(true) {
			int data = is.read(buf);
			os.write(buf);
			if(data == -1) {
				break;
			}
		}
		System.out.println("end of prog.");
		is.close();
		os.flush();
		os.close();
	}
}
