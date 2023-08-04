package co.micol.lms.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.lms.common.DataSource;
import co.micol.lms.notice.map.NoticeMapper;
import co.micol.lms.notice.service.NoticeService;
import co.micol.lms.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}
	
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}
	
	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.NoticeInsert(vo);
	}
	
	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.NoticeUpdate(vo);
	}
	
	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.NoticeDelete(vo);
	}
	
	
	
}
