package co.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectExe {
	public static void main(String[] args) throws Exception {
		// 스트림 -> 컬렉션.
		Member member = new Member("홍길동", "서울시", "010-1111");
		
		FileOutputStream fos = new FileOutputStream("c:/Temp/member.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(member);
		oos.flush(); oos.close();
		fos.flush(); fos.close();
		
		FileInputStream fis = new FileInputStream("c:/Temp/member.dat");
		ObjectInputStream ois= new ObjectInputStream(fis);
		
		Member mem = (Member) ois.readObject();
		ois.close();
		fis.close();
		
		
		System.out.println("end of prog.");
	}
	
	public void read() throws Exception{
		FileInputStream fis = new FileInputStream("c:/Temp/members.db");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		List<Member> list = (List<Member>) ois.readObject();
		for(Member member : list) {
			System.out.println(member);
		}
		ois.close();
		fis.close();
	}

	public void write() throws Exception {
		// 객체 -> 바이트 : 직렬화.
		List<Member> members = new ArrayList<>();
		members.add(new Member("홍길동", "서울", "010-1111"));

		FileOutputStream fos = new FileOutputStream("c:/Temp/members.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(members);
		oos.flush();oos.close();
		fos.flush();fos.close();
	}
}
