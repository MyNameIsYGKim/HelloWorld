package co.micol.miniproject.member.service;

import lombok.Data;

@Data
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private int memberAge;
	private String memberGender;
	private String memberTell;
	private String memberAddress;
	
	@Override
	public String toString() {
		System.out.print(memberId + " ");
		if(memberPassword != null) {
			System.out.println(memberPassword);
		}
		System.out.print(memberName + " ");
		System.out.print(memberAge + " ");
		System.out.print(memberGender + " ");
		System.out.print(memberTell + " ");
		System.out.println(memberAddress);
		return null;
	}
}
