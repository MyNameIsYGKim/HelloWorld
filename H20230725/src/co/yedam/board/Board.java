package co.yedam.board;

import java.io.Serializable;

public class Board implements Serializable {
	
	int no;
	String title;
	String content;
	String id;
	String date;
	
	// 생성자
	public Board(int no, String title, String content, String id, String date) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.id = id;
		this.date = date;
	}

	// getter, setter
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "no=" + no + ", 제목=" + title + ", 내용=" + content + ", id=" + id + ", 날짜=" + date + "]";
	}
}






