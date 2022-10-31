package org.zerock.controller.board.tmp;

import java.util.ArrayList;

public interface BoardMapper {

	int insert(BoardDto board);

	ArrayList<BoardDto> list();

	BoardDto select(int id);

	int update(BoardDto board);

	int delete();

}
