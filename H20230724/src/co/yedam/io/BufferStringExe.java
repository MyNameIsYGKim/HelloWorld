package co.yedam.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Member implements Serializable{
	private String name;
	private String addr;
	private String phone;
	Member(String name, String addr, String phone){
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "이름은 " + name + ", 주소는 " + addr + ", 번호는 " + phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}


public class BufferStringExe {

	public static void main(String[] args) throws Exception {
		
		List<Member> members = new ArrayList<>();
		// 보조스트림의 메소드 활용.
		FileInputStream fis = new FileInputStream("c:/Temp/address.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		while(true) {
			String str = br.readLine(); // 한문장씩 읽기.
			if(str == null) {
				break;
			}
			String[] data = str.split(" ");
			Member mem = new Member(data[0], data[1], data[2]);
			members.add(mem);
		}
		
		for(Member member : members) {
			System.out.println(member.toString());
		}
		
		System.out.println("end of prg.");
		br.close();
		isr.close();
		fis.close();
	}

}
