package co.yedam;

import java.util.Scanner;

public class PrintStreamExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("값>>> ");
		String result = scn.nextLine();
		System.out.println("입력값 : " + Integer.parseInt(result)*2);
	}

}
