package org.zerock.service.board;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.board.BoardDto;
import org.zerock.mapper.board.BoardMapper;

@Service
public class BoardSerivce {

	@Autowired
	private BoardMapper mapper;
	

	
	//---------c-----------
	public int register(BoardDto board) {
		return mapper.insert(board);
	}
	
	//---------r-----------
	public List<BoardDto> listBoard() {
		return mapper.list();
	}
	public BoardDto get(int id) {
		return mapper.select(id);
	}
	
	
	//---------u-----------
	public int update(BoardDto board) {	
		return mapper.update(board);	
	}
	
	//---------d-----------
	public int remove(int id) {
		return mapper.delete(id);
	}
	
}





