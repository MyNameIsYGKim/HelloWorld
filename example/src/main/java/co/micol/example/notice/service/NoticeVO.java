package co.micol.example.notice.service;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	
	
	private LocalDate noticeDate;
	private String noticeAttech;
	private String noticeAttechDir;
	private int noticeHit;
}
