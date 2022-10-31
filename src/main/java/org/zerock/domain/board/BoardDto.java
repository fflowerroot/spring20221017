package org.zerock.domain.board;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {   // Data Transfer Object

	
	// 컬럼/속성/필드/프로퍼티 
	
	private int id;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime inserted;
}
