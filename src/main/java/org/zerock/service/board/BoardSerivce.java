package org.zerock.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.domain.board.PageInfo2;
import org.zerock.mapper.board.BoardMapper;

@Service    //원래 @Component를 붙임 --> 비지니스로직을 담고 있는 component를 service라고 함
public class BoardSerivce {

	@Autowired
	private BoardMapper mapper;

	
	// ---------c-----------
	public int register(BoardDto board) {  //아무 역할 없이 mapper.insert(board) 호출 / 단지 메서드명이 register에서 insert로 바뀜.
		return mapper.insert(board);
	}

	// ---------r-----------
	public List<BoardDto> listBoard(int page, String type, String keyword, PageInfo pageInfo) {
		
		
		int records = 10;
		int offset = (page - 1) * records;
		int countAll = mapper.countAll(type, "%" + keyword + "%");
		int lastPage = (countAll - 1) / records + 1;
		int leftPageNumber = (page - 1) / 10 * 10 + 1;
		int rightPageNumber = leftPageNumber + 9;
		rightPageNumber = Math.min(lastPage, rightPageNumber);
		// 이전버튼 유무
		boolean hasPrevButton = page > 10;
		// 다음버튼 유무
		boolean hasNextButton = page <= (lastPage - 1) / 10 * 10;
		// 이전버튼 눌렀을 때 가는 페이지 번호
		int jumpPrevPageNumber = (page - 1) / 10 * 10 - 9;
		int jumpNextPageNumber = (page - 1) / 10 * 10 + 11;
		pageInfo.setHasPrevButton(hasPrevButton);
		pageInfo.setHasNextButton(hasNextButton);
		pageInfo.setJumpNextPageNumber(jumpNextPageNumber);
		pageInfo.setJumpPrevPageNumber(jumpPrevPageNumber);
		pageInfo.setCurrentPageNumber(page);
		pageInfo.setLastPageNumber(lastPage);
		pageInfo.setLeftPageNumber(leftPageNumber);
		pageInfo.setRightPageNumber(rightPageNumber);
		return mapper.list(offset, records, type, "%" + keyword + "%");
	}

	public BoardDto get(int id) {
		return mapper.select(id);
	}

	// ---------u-----------
	public int update(BoardDto board) {
		return mapper.update(board);
	}

	// ---------d-----------
	public int remove(int id) {
		return mapper.delete(id);
	}

}
