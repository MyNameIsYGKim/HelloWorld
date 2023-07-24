package co.yedam.io;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;

public class MemberManage {
	// 추가, 수정, 삭제, 목록, 저장.
	List<Member> members = new ArrayList<>();

	MemberManage() {
//		try {
//			FileReader fr = new FileReader("c:/Temp/members.text");
//			BufferedReader br = new BufferedReader(fr);
//			
//			while(true) {
//				String str = br.readLine();
//				// str = "김길동 부산 010";
//				if(str == null) {
//					break;
//				}
//				String[] data = str.split(" ");
//				members.add(new Member(data[0], data[1], data[2])); 
//			}
//			System.out.println("members 추가 완료.");
//			
//		} catch (Exception e) {
////			e.printStackTrace();
//		}

		FileInputStream fis;
		try {
			fis = new FileInputStream("c:/Temp/members.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			members = (List<Member>) ois.readObject();
			ois.close();
			fis.close();
			
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	boolean addMember(Member member) { // 추가
		return members.add(member);
	}

	boolean editMember(Member member) { // 수정
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(member.getName())) {
//				members.get(i).setAddr(member.getAddr());
				members.get(i).setPhone(member.getPhone());
				return true;
			}
		}
		return false;
	}

	boolean delMember(String name) { // 삭제
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(name)) {
				members.remove(i);
				return true;
			}
		}
		return false;
	}

	List<Member> list() {
		return members;
	}
	void save1() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/Temp/members.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(members);
			oos.flush();oos.close();
			fos.flush();fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void save() {
		try {
			FileWriter fw = new FileWriter("c:/Temp/members.text");
			BufferedWriter br = new BufferedWriter(fw);

			for (Member member : members) {
				String data = member.getName() + " " + member.getAddr() + " " + member.getPhone();
				br.write(data + "\n");
			}
			br.flush();
			br.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
