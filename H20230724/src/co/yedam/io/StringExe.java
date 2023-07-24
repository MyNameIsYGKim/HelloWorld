package co.yedam.io;

import java.io.FileWriter;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("c:/Temp/address.txt");
		Scanner scn = new Scanner(System.in);
		
		String temp = "";
		while(true) {
			System.out.println("입력>> ");
			temp = scn.nextLine();
			if(temp.equals("-1")) {
				break;
			}
			
			fw.write(temp+"\n");
		}
		fw.flush();
		fw.close();
		scn.close();
		System.out.println("end of prog.");
	}
}
