package co.yedam.product;

import java.util.Scanner;

public class ProductApp {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		ProductManager manager = new ProductManager();
		boolean run = true;
		
		manager.readFromFile(); // 파일 불러오기.
		
		while (run) {
			try {
				manager.printMenu(); // 메뉴.
				int menu = Integer.parseInt(scn.nextLine());

				if (menu == PRINT_MENU.INPUT) {
					manager.inputProduct();
					continue;

				} else if (menu == PRINT_MENU.BUY) {
					manager.buyProduct();
					continue;

				} else if (menu == PRINT_MENU.SELL) {
					manager.sellProduct();
					continue;

				} else if (menu == PRINT_MENU.LEFT) {
					manager.leftAmountList();
					continue;

				} else if(menu == PRINT_MENU.DEL) {
					manager.dellProduct();
					continue;
					
				}else if (menu == PRINT_MENU.EXIT) {
					System.out.println("종료합니다.");
					try {
						manager.storeToFile();
					} catch (Exception e) {
						
					}
					run = false;

				} else {
					System.out.println("잘못된 입력.");
				}

			} catch (java.lang.NumberFormatException e) {
				System.out.println("잘못된 입력.");
			}
		} // end of while.

	} // end of main.
}
