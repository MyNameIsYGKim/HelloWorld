package co.yedam.memo;

public class MemoApp {
	// MemoApp.java
	// 등록(addMemo)
	// 수정(editMemo) 번호, 내용
	// 삭제(delMemo) 번호
	// 목록(memoList)
	// 조회(findMemo) 번호
	
	// 1 장보기 230719
	// 2 운동하기 230718
	Memo[] memo = new Memo[50];
	int memoNum = 0;
	
	// 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
	
	// 등록(addMemo)
	boolean addMemo(Memo mm) {
		if(memoNum >= 50) { // 공간이 없으면 실패.
			return false;
		}
		for(int i=0; i < memo.length; i++) {
			if(memo[i] == null) {
				memoNum = i;
				memo[memoNum] = mm;
				break;
			}
			
		}
		return true;
	}
	
	// 수정(editMemo) 번호, 내용
	void editMemo(int num, String contents) {
		for(int i=0; i<memo.length; i++) {
			if(memo[i] != null) {
				if(memo[i].num == num) {
					memo[i].contents = contents;
					System.out.println("수정완료.");
					break;
				}else {
					System.out.println("없는 번호입니다.");
				}
			}
		}
	}
	
	// 삭제(delMemo) 번호
	void delMemo(int num) {
		for(int i=0; i<memo.length; i++) {
			if(memo[i] != null) {
				if(memo[i].num == num) {
					memo[i].contents = null;
				}else {
					System.out.println("없는 번호입니다.");
				}
			}
		}
	}
	
	// 목록(memoList)
	void memoList() {
		for(int i=0; i<memo.length; i++) {
			if(memo[i] != null) {
				System.out.println("번호: "+memo[i].num+", 내용: "+memo[i].contents+", 날짜: "+memo[i].date);
			}
		}
	}
	
	// 조회(findMemo) 번호
	void findMemo(int num) {
		for(int i=0; i<memo.length; i++) {
			if(memo[i] != null && memo[i].num == num) {
				System.out.println("번호: "+memo[i].num+", 내용: "+memo[i].contents+", 날짜: "+memo[i].date);
				break;
			}else {
				System.out.println("없는 번호입니다.");
				break;
			}
		}
	}

}
