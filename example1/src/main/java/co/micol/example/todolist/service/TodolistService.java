package co.micol.example.todolist.service;

import java.util.List;

public interface TodolistService {
	public List<TodolistVO> list();
	public int insert(TodolistVO vo);
	public int update(TodolistVO vo);
	public int delete(int todolistNO);
}
