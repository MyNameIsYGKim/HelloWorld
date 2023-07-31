package co.yedam.warehousing.menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import co.yedam.warehousing.history.service.HistoryService;
import co.yedam.warehousing.history.service.HistoryVO;
import co.yedam.warehousing.history.serviceImpl.HistoryServiceImpl;
import co.yedam.warehousing.product.service.ProductService;
import co.yedam.warehousing.product.service.ProductVO;
import co.yedam.warehousing.product.serviceImpl.ProductServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private ProductService ps = new ProductServiceImpl();
	private HistoryService hs = new HistoryServiceImpl();
	private ProductVO pvo = new ProductVO();
	private HistoryVO hvo = new HistoryVO();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	private void mainTitle() { // 전체메뉴
		System.out.println("┌─ <창고 관리> ─┐");
		System.out.println("│  1.상품 관리  │");
		System.out.println("│  2.입출 관리  │");
		System.out.println("│    3.종료    │");
		System.out.println("└─────────────┘");
	}

	private void productTitle() { // 상품관리 메뉴
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

	private void historyTitle() { // 입출관리 메뉴
		System.out.println("┌─ <입출 관리> ─┐");
		System.out.println("│    1.구매    │");
		System.out.println("│    2.판매    │");
		System.out.println("│    3.폐기    │");
		System.out.println("│   4.전체조회  │");
		System.out.println("│   5.상세조회  │");
		System.out.println("│   6.내역삭제  │");
		System.out.println("│    7.뒤로    │");
		System.out.println("│    8.종료    │");
		System.out.println("└─────────────┘");
	}

	public void run() throws Exception { // 전체
		boolean b = false;

		do {
			try {
				mainTitle();
				int key = Integer.parseInt(sc.nextLine());
				switch (key) {
				case 1:
					if (productManager() == 0) { // 상품관리
						System.out.println("종료합니다");
						b = true;
						break;
					} else {
						break;
					}
				case 2:
						if (historyManager() == 0) { // 거래내역 관리
							b = true;
						} else {
							break;
						}
				case 3:
					System.out.println("종료합니다.");
					b = true;
					break;
				default:
					System.out.println("잘못된 입력.");
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력. 처음으로..");
			}
		} while (!b);
		sc.close();
	}

	public int productManager() { // 상품관리
		boolean b = false;
		int key = 0;
		do {
			productTitle();
			key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1:
				if (productInsert()) {
					System.out.println("등록성공!");
				} else {
					System.out.println("등록실패!");
				}
				return 1;
			case 2:
				if (productUpdate()) {
					System.out.println("수정성공!");
				} else {
					System.out.println("수정실패!");
				}
				return 1;
			case 3:
				if (productDelete()) {
					System.out.println("삭제성공!");
				} else {
					System.out.println("삭제실패!");
				}
				return 1;
			case 4:
				productSelectList();
				return 1;
			case 5:
				productSelect();
				return 1;
			case 6:
				b = true;
				return 1;
			case 7:
				b = true;
				return 0;
			default:
				System.out.println("잘못된 입력.");
			}
		} while (!b);
		if (key != 7) {
			sc.close();
		}
		return 1;
	}

	private int getProductNo() { // 상품번호 지정하기
		int n = 1;
		for (int i = 0; i < ps.productSelectList().size(); i++) {
			if (ps.productSelectList().get(i) != null) {
				n++;
			} else {
				break;
			}
		}
		return n;
	}

	private boolean productInsert() { // 상품관리-등록
		System.out.println("상품등록>> ");
		System.out.print("상품명, 가격, 위치>> ");
		String[] str = sc.nextLine().split(", ");
		int no = getProductNo();
		ProductVO vo = new ProductVO();
		vo.setProductNo(no);
		vo.setProductName(str[0]);
		vo.setProductPrice(Integer.parseInt(str[1]));
		vo.setProductLocation(str[2]);
		vo.setProductAmount(0);
		ps.productInsert(vo);
		return true;
	}

	private boolean productUpdate() { // 상품관리-수정
		System.out.println("상품수정>> ");
		System.out.print("변경할 상품의 번호, 변경> 상품명, 가격, 위치>> ");
		String[] str = sc.nextLine().split(", ");

		ProductVO vo = new ProductVO();
		vo.setProductNo(Integer.parseInt(str[0]));
		vo.setProductName(str[1]);
		vo.setProductPrice(Integer.parseInt(str[2]));
		vo.setProductLocation(str[3]);
		ps.productUpdate(vo);
		return true;
	}

	private boolean productDelete() { // 상품관리-삭제
		System.out.println("상품삭제>> ");
		System.out.println("삭제할 상품의 번호> ");
		int no = sc.nextInt();
		ps.productDelete(no);
		return true;
	}

	private void productSelectList() { // 상품관리-전체조회
		if (ps.productSelectList() != null) {
			System.out.println("리스트를 불러옵니다..");
			System.out.printf("%-4s %-7s %6s %4s %4s\n", "번호", "상품명", "가격", "위치", "재고");
			for (int i = 0; i < ps.productSelectList().size(); i++) {
				ps.productSelectList().get(i).string();
			}
			System.out.println("조회완료!");
		}
	}

	private void productSelect() { // 상품관리-상세조회
		System.out.println("조회할 키워드>> ");
		String str = sc.nextLine();
		if (ps.productSelect(str) != null) {
			System.out.println("리스트를 불러옵니다..");
			for (int i = 0; i < ps.productSelect(str).size(); i++) {
				System.out.println(ps.productSelect(str).get(i).toString());
			}
			System.out.println("조회완료!");
		}
	}

	public int historyManager() throws ParseException { // 거래내역 관리
		boolean b = false;
		int key = 0;
		do {
				historyTitle();
				key = Integer.parseInt(sc.nextLine());
				switch (key) {
				case 1:
					if (historyInsert("구매")) {
						System.out.println("구매등록!");
					} else {
						System.out.println("구매실패!");
					}
					break;
				case 2:
					if (historyInsert("판매")) {
						System.out.println("구매등록!");
					} else {
						System.out.println("구매실패!");
					}
					break;
				case 3:
					if (historyInsert("폐기")) {
						System.out.println("구매등록!");
					} else {
						System.out.println("구매실패!");
					}
					break;
				case 4:
					historySelectList();
					break;
				case 5:
					historySelect();
					break;
				case 6:
					if (historyDelete()) {
						System.out.println("삭제성공!");
					} else {
						System.out.println("삭제실패!");
					}
					break;
				case 7:
					b = true;
					break;
				case 8:
					b = true;
					return 0;
				default:
					System.out.println("잘못된 입력.");
				}
			
		} while (!b);
		if (key != 7) {
			sc.close();
		}
		return 1;
	}

	private int gethistoryNo() { // 입출번호 지정하기
		int n = 1;
		for (int i = 0; i < hs.historySelectList().size(); i++) {
			if (hs.historySelectList().get(i) != null) {
				n++;
			} else {
				break;
			}
		}
		return n;
	}

	private boolean historyInsert(String type) throws ParseException { // 입출관리-구매,판매,폐기
		System.out.println("상품구매>> ");
		System.out.println("상품번호, 거래가격, 거래량, 날짜>> ");
		String[] str = sc.nextLine().split(", ");
		int no = gethistoryNo();
		String name = "";
		int price = 0;
		int cost = Integer.parseInt(str[1]) * Integer.parseInt(str[2]);
		Date date = formatter.parse(str[3]);

		for (int i = 0; i < ps.productSelectList().size(); i++) {
			int amount = ps.productSelectList().get(i).getProductAmount();
			if (ps.productSelectList().get(i).getProductNo() == Integer.parseInt(str[0])) {
				name = ps.productSelectList().get(i).getProductName();
				price = ps.productSelectList().get(i).getProductPrice();
				if (type.equals("구매")) {
					amount += Integer.parseInt(str[2]);
				} else if (type.equals("판매") || type.equals("폐기")) {
					amount -= Integer.parseInt(str[2]);
				} else {
					return false;
				}
				break;
			}
		}

		HistoryVO vo = new HistoryVO();
		vo.setHistoryNo(no);
		vo.setHistoryType(type);
		vo.setProductNo(Integer.parseInt(str[0]));
		vo.setProductName(name);
		vo.setProductPrice(price);
		vo.setHistorySellPrice(Integer.parseInt(str[1]));
		vo.setHistoryAmount(Integer.parseInt(str[2]));
		if (type.equals("구매") || type.equals("판매")) {
			vo.setHistoryCost(cost);
		} else if (type.equals("폐기")) {
			vo.setHistoryCost(price * Integer.parseInt(str[2]));
		}
//		vo.setHistoryDate((java.sql.Date) formatter.parse(str[3]));
		vo.setHistoryDate(formatter.parse(str[3]));
		hs.historyInsert(vo);
		return true;
	}

	private void historySelectList() { // 입출관리-전체조회
		if (hs.historySelectList() != null) {
			System.out.println("리스트를 불러옵니다..");
			for (int i = 0; i < hs.historySelectList().size(); i++) {
				System.out.println(hs.historySelectList().get(i).toString());
			}
			System.out.println("조회완료!");
		}
	}

	private void historySelect() { // 입출관리-상세조회
		System.out.println("조회할 키워드>> ");
		String str = sc.nextLine();
		if (hs.historySelect(str) != null) {
			System.out.println("리스트를 불러옵니다..");
			for (int i = 0; i < hs.historySelect(str).size(); i++) {
				System.out.println(hs.historySelect(str).get(i).toString());
			}
			System.out.println("조회완료!");
		}
	}

	private boolean historyDelete() { // 입출관리-삭제
		System.out.println("내역삭제>> ");
		System.out.println("삭제할 내역의 번호> ");
		int no = sc.nextInt();
		hs.historyDelete(no);
		return true;
	}
} // end of main.
