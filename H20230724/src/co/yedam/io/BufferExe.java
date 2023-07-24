package co.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferExe {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("c:/Temp/jdk.exe");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("c:/Temp/jdk_copy.exe");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int data = 0;
		while((data = bis.read()) != -1) {
//			int data = bis.read();
			bos.write(data);
//			if(data == -1) {
//				break;
//			}
		}
		System.out.println("end of prog.");
		bos.flush(); bos.close(); fos.close();
		bis.close(); fis.close();
	}

}
