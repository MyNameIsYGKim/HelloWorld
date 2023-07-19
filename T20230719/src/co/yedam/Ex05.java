package co.yedam;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		Friend friend = new Friend();
		
		while(run) {
			System.out.println("입력>> 1.등록 2.목록 3.전화번호수정 4.삭제 5.종료");
			int put = Integer.parseInt(scn.nextLine());
			
			if(put == 1) {
				System.out.println("이름 입력>> ");
				String name = scn.nextLine();
				System.out.println("전화번호 입력>> ");
				String phone = scn.nextLine();
				System.out.println("생일 입력>> ");
				int birth = Integer.parseInt(scn.nextLine());
				System.out.println("키 입력>> ");
				double height = Double.parseDouble(scn.nextLine());
				
				friend.register(name, phone, birth, height);
				
			}else if(put == 2){
				friend.list();
				
			}else if(put == 3){
				System.out.println("수정할 친구의 이름>> ");
				String name = scn.nextLine();
				System.out.println("수정할 전화번호 >> ");
				String phone = scn.nextLine();
				
				friend.modify(name, phone);
				
			}else if(put == 4){
				friend.remove();
				
			}else if(put == 5){
				System.out.println("종료합니다.");
				run = false;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

}
