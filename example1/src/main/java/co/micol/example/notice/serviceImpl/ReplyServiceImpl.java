package co.micol.example.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.example.common.DataSources;
import co.micol.example.notice.mapper.ReplyMapper;
import co.micol.example.notice.service.ReplyService;
import co.micol.example.notice.service.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);
	
	@Override
	public boolean addReply(ReplyVO vo) {
		return map.insert(vo) == 1;
	}

	@Override
	public boolean editReply(ReplyVO vo) {
		return map.update(vo) == 1;
	}

	@Override
	public boolean delReply(int replyId) {
		return map.delete(replyId) == 1;
	}

	@Override
	public ReplyVO getReply(int replyId) {
		return map.select(replyId);
	}

	@Override
	public List<ReplyVO> replyList(int noticeId) {
		return map.selectList(noticeId);
	}

}
