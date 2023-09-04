package co.micol.example.todolist.mapper;

import java.util.List;

import co.micol.example.todolist.service.TodolistVO;

public interface TodolistMapper {
	public List<TodolistVO> list();
	public int insert(TodolistVO vo);
	public int update(TodolistVO vo);
	public int delete(int todolistNO);
}
