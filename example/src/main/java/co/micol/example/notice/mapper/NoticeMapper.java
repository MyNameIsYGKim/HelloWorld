package co.micol.example.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.example.notice.service.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	List<NoticeVO> noticeSelectList(@Param("Key") String key, @Param("val") String val); // 검색
	
	List<NoticeVO> noticeSearchList(@Param("Key") String key, @Param("val") String val); // 검색
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	void noticeUpdateHit(int id); // 조회수 증가
}
