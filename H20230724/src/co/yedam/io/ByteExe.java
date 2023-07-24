package co.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteExe {

	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("c:/Temp/test1.db");
		
		InputStream is = new FileInputStream("c:/Temp/test1.db");
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		os.write(a);
		os.write(b);
		os.write(c);
		
		os.flush();
		os.close();
		
		while(true) {
			int data = is.read();
			if(data == -1) {
				break;
			}
			System.out.println(data);
		}
		is.close();
		System.out.println("end of .prog.");
	}

}
