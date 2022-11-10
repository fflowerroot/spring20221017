package org.zerock.mapper.board;

import java.util.List;

import org.zerock.domain.board.BoardDto;




public interface BoardMapper {

	//---------c-----------
	int insert(BoardDto board);
	
	//---------r-----------
	List<BoardDto> list(int offset, int records, String type, String keyword);
	
	BoardDto select(int id);
	
	int countAll(String type, String keyword);
	
	//---------u-----------
	int update(BoardDto board);
	
	//---------d-----------
	int delete(int id);

	//--
	int insertFile(int id, String fileName);

	int deleteFileByBoardId(int id);

	int deleteFileByBoardIdAndFileName(int id, String fileName);


}








