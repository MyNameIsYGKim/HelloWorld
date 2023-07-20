package co.yedam.dao;

public class OracleDao implements Dao{
	//insert(), modify(), remove(), search()
	public void insert() {
		System.out.println("Oracle 등록.");
	}
	public void modify() {
		System.out.println("Oracle 수정.");
	}
	public void remove() {
		System.out.println("Oracle 삭제.");
	}
	public void search() {
		System.out.println("Oracle 조회.");
	}
}
