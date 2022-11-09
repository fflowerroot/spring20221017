package org.zerock.domain.board;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {   // Data Transfer Object

	
	// 컬럼/속성/필드/프로퍼티 
	
	private int id; // db에서 오토로 설정
	private String title;
	private String content;
	private String writer;
	private LocalDateTime inserted; // db에서 오토로 설정
}
