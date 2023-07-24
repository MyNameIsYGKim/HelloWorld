package co.yedam.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

// 이름/주소/연락처 -> 3건 입력. c:/Temp/address2.txt 저장.
public class ScannerBufferExe {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		FileWriter fw = new FileWriter("c:/Temp/address2.text");
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(true) {
			System.out.println("이름, 주소, 연락처 입력>> ");
			String str = scn.nextLine();
			if(str.equals("-1")) {
				break;
			}
			bw.write(str + "\n");
		}
		bw.flush();
		bw.close();
		fw.close();
		scn.close();
		
		System.out.println("end of prog.");
	}
}
