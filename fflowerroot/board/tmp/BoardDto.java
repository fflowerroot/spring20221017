package org.zerock.controller.board.tmp;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	private String title;
	private String content;
	private String writer;
	private int id;
	private LocalDateTime inserted;
}
