package co.micol.example.notice.mapper;

import java.util.List;

import co.micol.example.notice.service.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public int update(ReplyVO vo);
	public int delete(int replyId);
	public ReplyVO select(int replyId);
	public List<ReplyVO> selectList(int noticeId);
}
