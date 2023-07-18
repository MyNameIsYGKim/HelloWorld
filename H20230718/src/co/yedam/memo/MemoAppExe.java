package co.yedam.memo;

import java.util.Scanner;

import co.yedam.bank.Account;

public class MemoAppExe {
	public static void main(String[] args) {
		MemoApp app = new MemoApp();
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		Memo m1 = new Memo(1, "토요일에 정처기 시험", "230701");
		app.memo[0] = m1;
		Memo m2 = new Memo(2, "매일 공부하기", "230101");
		app.memo[1] = m2;
		Memo m3 = new Memo(3, "분리수거하기", "230718");
		app.memo[2] = m3;
		
		while(run) {
			System.out.println("선택>> 1.등록 2.수정 3.삭제 4.목록 5.조회 6.종료");
			int put = Integer.parseInt(scn.nextLine());
			
			if(put == 1) { // 등록(addMemo)
				System.out.println("입력> (번호, 내용, 날짜)");
				int put1 = Integer.parseInt(scn.next());
				String put2 = scn.next();
				String put3 = scn.nextLine();
				for(int i=0; i < app.memo.length; i++) {
//					if(memo2[i].num != put1) {
						Memo memo = new Memo(put1, put2, put3);
						
						if(app.addMemo(memo)) {
							System.out.println("등록완료.");
						}else {
							System.out.println("등록실패.");
						}
						break;
//					}else {
//						System.out.println("이미 있는 글번호입니다.");
//					}
				}
				
				
				
			}else if(put == 2) { // 수정(editMemo)
				System.out.println("입력> (번호, 내용)");
				int put1 = Integer.parseInt(scn.next());
				String put2 = scn.nextLine();
				
				app.editMemo(put1, put2);
				System.out.println("수정완료.");
				
			}else if(put == 3) { // 삭제(delMemo) 번호
				System.out.println("삭제할 글번호> ");
				int put1 = Integer.parseInt(scn.next());
				
				app.delMemo(put1);
				System.out.println("삭제완료.");
				
			}else if(put == 4) { // 목록(memoList)
				app.memoList();
				
			}else if(put == 5) { // 조회(findMemo) 번호
				System.out.println("조회할 글번호> ");
				int put1 = Integer.parseInt(scn.nextLine());
				
				app.findMemo(put1);
				
			}else if(put == 6) {
				System.out.println("종료합니다.");
				
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
