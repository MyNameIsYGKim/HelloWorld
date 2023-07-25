package co.yedam.grade;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			manager.menu();
			int menu = Integer.parseInt(scn.nextLine());
			
		}
		
	}

}
