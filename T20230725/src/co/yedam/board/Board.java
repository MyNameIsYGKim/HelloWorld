package co.yedam.board;

import java.io.Serializable;

public class Board implements Serializable{
	int no;
	String title;
	String content;
	String writer;
	String date;
	
	public Board(int no, String title, String content, String writer, String date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}
	
	public Board() {}

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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", 제목=" + title + ", 내용=" + content + ", 작성자=" + writer + ", 날짜=" + date
				+ "]";
	}
	
	
	
}






