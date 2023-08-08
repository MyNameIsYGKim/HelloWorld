package co.micol.example.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	List<NoticeVO> noticeSelectList(String key, String val); // 검색
	
	List<NoticeVO> noticeSearchtList(String key, String val); // 검색
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeupdateHit(int id); // 조회수 증가
}
