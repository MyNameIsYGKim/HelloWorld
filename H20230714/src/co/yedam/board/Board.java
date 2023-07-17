package co.yedam.board;

public class Board {
	private int poNo;
	private String poTitle;
	private String poContents;
	private String poWriter;
	
	public Board() { // 기본생성자.
		
	}
	
	public Board(int poNo, String poTitle, String poContents, String writer) { // 양식.
		super();
		this.poNo = poNo;
		this.poTitle = poTitle;
		this.poContents = poContents;
		this.poWriter = writer;
	}
	
	public int getPoNo() {
		return poNo;
	}
	public void setPoNo(int poNo) {
		this.poNo = poNo;
	}
	public String getPoTitle() {
		return poTitle;
	}
	public void setPoTitle(String poTitle) {
		this.poTitle = poTitle;
	}
	public String getPoContents() {
		return poContents;
	}
	public void setPoContents(String poContents) {
		this.poContents = poContents;
	}
	public String getWriter() {
		return poWriter;
	}
	public void setWriter(String poWriter) {
		this.poWriter = poWriter;
	}
	
	public String showInfo() {
		return "글번호: "+poNo+", 글제목: "+poTitle+", 작성자: "+poWriter;
	}
	
	public String detailInfo() {
		return "글번호: "+poNo+", 글제목: "+poTitle+", 글내용: "+poContents+", 작성자: "+poWriter;
	}
	
}
