package co.yedam.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

	Scanner scn = new Scanner(System.in);
	List<Product> list = new ArrayList<>();

	// 메뉴출력
	public void printMenu() {
		System.out.println("1.상품등록 2.구매관리 3.판매관리 4.현재재고 5.상품삭제 6.종료");
	}

	public int productNumber() { // 상품코드 설정.
		int no = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() > no) {
				no = list.get(i).getCode();
			}
		}
		return no + 1;
	} // end of printMenu();

	public void inputProduct() { // 1.상품등록
		int code = productNumber();
		System.out.println("등록) 상품명 >>");
		String name = scn.nextLine();
		System.out.println("등록) 가격 >>");
		int price = Integer.parseInt(scn.nextLine());

		Product product = new Product(code, name, price);
		if (list.add(product)) {
			System.out.println("등록성공.");
		} else {
			System.out.println("등록실패.");
		}
	} // end of inputProduct();

	public void buyProduct() { // 2.구매관리
		System.out.println("구매) 상품코드 >>");
		int num = Integer.parseInt(scn.nextLine());
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == num) {
				System.out.println("구매) 구매수량 >>");
				int amount = Integer.parseInt(scn.nextLine());
				System.out.println("구매) 구매날짜 >>");
				String date = scn.nextLine();
				if (amount > 0) {
					list.get(i).setLeftAmount(list.get(i).getLeftAmount() + amount);
					count++;
					System.out.println("구매완료.");
				} else {
					System.out.println("구매수량 입력오류.");
				}
			}
		}
		if (count == 0) {
			System.out.println("잘못된 상품코드.");
		}
	} // end of buyProduct();

	public void sellProduct() { // 3.판매관리
		System.out.println("판매) 판매코드 >>");
		int num = Integer.parseInt(scn.nextLine());
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == num) {
				System.out.println("판매) 판매수량 >>");
				int amount = Integer.parseInt(scn.nextLine());
				if (amount > 0 && amount < list.get(i).getLeftAmount()) {
					list.get(i).setLeftAmount(list.get(i).getLeftAmount() - amount);
					count++;
					System.out.println("판매완료.");
				} else {
					System.out.println("판매수량 입력오류.");
				}
			}
		}
		if (count == 0) {
			System.out.println("잘못된 상품코드.");
		}
	} // end of sellProduct();

	public void leftAmountList() { // 4.현재재고
//		try {
			if (list != null) {
				int count = 0;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) != null) {
						System.out.println(list.get(i).toString());
						count++;
					}
				}
				if(count == 0) {
					System.out.println("빈 목록입니다.");
				}
			}
//		} catch (java.lang.IndexOutOfBoundsException e) {
//			System.out.println("빈 목록입니다.");
//		}
	}
	
	public void dellProduct() { // 5.상품삭제
		System.out.println("삭제) 코드 >>");
		int num = Integer.parseInt(scn.nextLine());
		int count = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == num) {
				list.remove(i);
				count++;
				System.out.println("삭제완료.");
			}
		}
		if(count == 0) {
			System.out.println("잘못된 상품코드.");
		}
	}

	// 파일 불러오기
	public void readFromFile() {
		FileInputStream fis;
		try { 
			fis = new FileInputStream("c:/Temp/product.text");
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (List<Product>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	// 파일에 저장하기
	public void storeToFile() throws Exception {
		FileOutputStream fos = new FileOutputStream("c:/Temp/product.text");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
		fos.flush();
		fos.close();
	}
}
