package co.yedam.memo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager {

	Scanner scn = new Scanner(System.in);
	List<Memo> memoStorage = new ArrayList<>();

	public MemoManager() throws Exception {
		readFromFile();
	}

	// 메뉴출력.
	public void printMenu() {
		System.out.println("1.등록 2.검색 3.삭제 4.종료");
		System.out.println("선택> ");
	}

	private int getNextNo() {
		int no = 0;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getNo() > no) {
				no = memoStorage.get(i).getNo();
			}
		}
		return no + 1;
	} // end of getNextNo();

	public void inputData() { // 등록
		int no = getNextNo();
		System.out.println("날짜 입력>> ");
		String date = scn.nextLine();
		System.out.println("내용 입력>> ");
		String content = scn.nextLine();

		Memo memo = null;
		if (date.isEmpty()) {
			memo = new Memo(no, content);
		} else {
			memo = new Memo(no, date, content);
		}
		if (memoStorage.add(memo)) {
			System.out.println("정상 등록.");
		} else {
			System.out.println("등록 오류.");
		}
	} // end of inputData();

	public void search() { // 검색.
		System.out.println("날짜 입력>> ");
		String date = scn.nextLine();
		// 입력된 날짜의 메모를 출력.
		int num = 0;
		for (Memo memo : memoStorage) {
			if (memo.getDate().equals(date)) {
				System.out.println(memo.toString());
				System.out.println("조회 완료.");
				num++;
			}
		}
		if(num == 0) {
			System.out.println("조회 실패.");
		}
	}

	public void deleteData() { // 삭제.
		System.out.println("번호 입력>> ");
		int no = Integer.parseInt(scn.nextLine());

		int num = 0;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getNo() == no) {
				memoStorage.remove(i);
				System.out.println("삭제완료.");
				num++;
			}
		}
		if(num == 0) {
			System.out.println("잘못된 번호입니다.");
		}
	}

	public void storeToFile() throws Exception {
		// 출력스트림. (객체)
		FileOutputStream fos = new FileOutputStream("c:/Temp/Memo.text");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(memoStorage);
		oos.flush();
		oos.close();
		fos.flush();
		fos.close();
	}

	public void readFromFile() {
		// 입력스트림. (객체)
		FileInputStream fis;
		try {
			fis = new FileInputStream("c:/Temp/Memo.text");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Memo memo = (Memo) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
}
