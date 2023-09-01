package co.micol.example.ajax.mapper;

import java.util.List;

import co.micol.example.ajax.service.MembersVO;

public interface AjaxMapper {
	public int insert(MembersVO vo);
	public int update(MembersVO vo);
	public int delete(int mbrId);
	public List<MembersVO> list();
}
