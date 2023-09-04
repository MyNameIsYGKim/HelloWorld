package co.micol.example.todolist.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.example.common.DataSources;
import co.micol.example.todolist.mapper.TodolistMapper;
import co.micol.example.todolist.service.TodolistService;
import co.micol.example.todolist.service.TodolistVO;

public class TodolistServiceImpl implements TodolistService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private TodolistMapper map = sqlSession.getMapper(TodolistMapper.class);
	
	@Override
	public List<TodolistVO> list() {
		return map.list();
	}

	@Override
	public int insert(TodolistVO vo) {
		return map.insert(vo);
	}

	@Override
	public int update(TodolistVO vo) {
		return map.update(vo);
	}

	@Override
	public int delete(int todolistNO) {
		return map.delete(todolistNO);
	}

}
