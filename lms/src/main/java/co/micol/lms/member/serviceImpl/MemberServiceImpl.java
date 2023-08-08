package co.micol.lms.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.lms.common.DataSource;
import co.micol.lms.member.map.MemberMapper;
import co.micol.lms.member.service.MemberService;
import co.micol.lms.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true); // true하면 오토커밋. 안하면 안됨.
	MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public List<MemberVO> memberSelectList() {
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return map.memberDelete(vo);
	}
	
	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

}
