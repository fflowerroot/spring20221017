package org.zerock.domain.board;

import lombok.Data;

@Data
public class ReplyDto {
	private int boardId;
	private String content;
}
