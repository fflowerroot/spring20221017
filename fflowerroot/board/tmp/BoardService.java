package org.zerock.controller.board.tmp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardService { //원래 인터페이스도 만들어야하는데 프로젝트 규모가 작아서 바로 클래스를 만들기로함.
	
	@Autowired
	private BoardMapper mapper;
	
	public int register(BoardDto board) {
		return mapper.insert(board);
	}

	public ArrayList<BoardDto> listBoard() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	public BoardDto get(int id) {
		// TODO Auto-generated method stub
		return mapper.select(id);
	}

	public int uptade(BoardDto board) {
		// TODO Auto-generated method stub
		return mapper.update(board);
	}

	public int remove(int id) {
		// TODO Auto-generated method stub
		return mapper.delete();
	}
}
