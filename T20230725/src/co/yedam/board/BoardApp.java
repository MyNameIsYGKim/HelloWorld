package co.yedam.board;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BoardApp {

	static List<Board> boards = new ArrayList<>();
	
	public int getNextNo() {
		int no=0;
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getNo() > no) {
				no = boards.get(i).getNo();
			}
		}
		return no+1;
	}
	
	public String menu() throws Exception {
		return "1.추가 2.수정 3.조회 4.삭제 5.목록 9.종료";
	}
	
	public boolean register(Board board) {
		if(boards.add(board)) {
			return true;
		}
		return false;
	}
	
	public boolean modify(Board board) {
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getNo() == board.no) {
				boards.set(i, board);
				return true;
			}
		}
		return false;
	}
	
	public String search(int no) {
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getNo() == no) {
				return boards.get(i).toString();
			}
		}
		return null;
	}
	
	public boolean remove(int no) {
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getNo() == no) {
				boards.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public List<Board> list() {
		return boards;
	}

	// 파일 불러오기
	public static List<Board> readFromFile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("c:/Temp/boardList.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Board> list = (List<Board>) ois.readObject();
			return list;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	// 파일 저장하기
	public static void toSaveFile() throws Exception {
		
		FileOutputStream fos = new FileOutputStream("c:/Temp/boardList.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(boards);
		oos.flush();oos.close();
		fos.flush();fos.close();
	}
}

















