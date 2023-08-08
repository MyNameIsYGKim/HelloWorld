package co.micol.example.member.service;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberImg;
	private String memberTel;
	private String memberAddress;
	private LocalDate memberEdate;
	private LocalDate memberSdate;
	private String memberAuthor;
}
