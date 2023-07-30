package co.yedam.warehousing.menu;

import java.util.Scanner;

import co.yedam.warehousing.history.service.HistoryVO;
import co.yedam.warehousing.product.service.ProductService;
import co.yedam.warehousing.product.service.ProductVO;
import co.yedam.warehousing.product.serviceImpl.ProductServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private ProductService ps = new ProductServiceImpl();
	private ProductVO pvo = new ProductVO();
	private HistoryVO hvo = new HistoryVO();

	private void mainTitle() {
		System.out.println("┌── <창고 관리> ──┐");
		System.out.println("│   1.상품 관리   │");
		System.out.println("│ 2.거래내역 관리  │");
		System.out.println("│     3.종료     │");
		System.out.println("└───────────────┘");
	}

	private void productTitle() {
		System.out.println("┌─ <상품 관리> ─┐");
		System.out.println("│    1.등록    │");
		System.out.println("│    2.수정    │");
		System.out.println("│    3.삭제    │");
		System.out.println("│   4.전체조회  │");
		System.out.println("│   5.상세조회  │");
		System.out.println("│    6.뒤로    │");
		System.out.println("│    7.종료    │");
		System.out.println("└─────────────┘");
	}

	private void historyTitle() {
		System.out.println("┌─ <거래내역 관리> ─┐");
		System.out.println("│     1.구매      │");
		System.out.println("│     2.판매      │");
		System.out.println("│     3.폐기      │");
		System.out.println("│    4.전체조회    │");
		System.out.println("│    5.상세조회    │");
		System.out.println("│    6.내역삭제    │");
		System.out.println("│     7.뒤로      │");
		System.out.println("│     8.종료      │");
		System.out.println("└────────────────┘");
	}

	public void run() { // 전체
		boolean b = false;
		do {
			mainTitle();
			int key = sc.nextInt();
			switch (key) {
			case 1:
				productManager();
				break;
			case 2:
				historyManager();
				break;
			case 3:
				System.out.println("종료합니다.");
				b = true;
				break;
			}
		} while (!b);
		sc.close();
	}
	
	public void productManager() { // 상품관리
		boolean b = false;
		do {
			productTitle();
			int key = sc.nextInt();
			switch(key) {
				case 1 :
					if(productInsert()) {
						System.out.println("등록성공!");
					}else {
						System.out.println("등록실패!");
					}
					break;
				case 2 :

					break;
				case 3 :

					break;
				case 4 :

					break;
				case 5 :

					break;
				case 6 :

					break;
				case 7 :

					break;
			}
		} while(!b);
		sc.close();
	}
	
	private int getProductNo() {
		int n = 0;
		return n;
	}
	
	private boolean productInsert() { // 상품관리-등록
		System.out.println("상품등록>> ");
		System.out.print("번호, 상품명, 가격, 위치");
		String[] str = sc.next().split(", ");
		
		ProductVO vo = new ProductVO();
		vo.setProductNo(Integer.parseInt(str[0]));
		vo.setProductName(str[1]);
		vo.setProductPrice(Integer.parseInt(str[2]));
		vo.setProductLocation(str[3]);
		vo.setProductAmount(0);
		ps.productInsert(vo);
		return true;
	}
	
	private void productUpdate() {
		System.out.println("상품수정>> ");
		System.out.print("변경할 상품의 번호, 변경> 상품명, 가격, 위치");
		String[] str = sc.next().split(", ");
		
		ProductVO vo = new ProductVO();
		vo.setProductNo(Integer.parseInt(str[0]));
		vo.setProductName(str[1]);
		vo.setProductPrice(Integer.parseInt(str[2]));
		vo.setProductLocation(str[3]);
		ps.productUpdate(vo);
	}
	
	public void historyManager() {
		
	}
}













