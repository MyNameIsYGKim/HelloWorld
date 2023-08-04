package co.micol.lms.notice.map;

import java.util.List;

import co.micol.lms.notice.service.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int NoticeInsert(NoticeVO vo);
	int NoticeDelete(NoticeVO vo);
	int NoticeUpdate(NoticeVO vo);
}
