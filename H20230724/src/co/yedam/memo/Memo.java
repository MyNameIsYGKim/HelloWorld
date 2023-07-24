package co.yedam.memo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Memo {
	// 메모번호(키), 날짜, 내용.
	private int no;
	private String date;
	private String content;
	
	public Memo(int no, String date, String content) {
		this.no = no;
		this.date = date;
		this.content = content;
	}
	
	public Memo(int no, String content) {
		this.no = no;
		this.content = content;
		// 날짜 기본값으로 오늘날짜.
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.date = sdf.format(today);
	}
	
	@Override
	public String toString() {
		return "번호: " + no + ", 날짜: " + date + ", 내용: " + content;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
