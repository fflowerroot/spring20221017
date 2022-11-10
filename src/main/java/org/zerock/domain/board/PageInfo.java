package org.zerock.domain.board;

import lombok.Data;

@Data
public class PageInfo {
	private int lastPageNumber;
	private int leftPageNumber;
	private int rightPageNumber;
//	private int currentPageNumber;
	private int page;
	private int jumpPrevPageNumber;
	private int jumpNextPageNumber;
	private boolean hasPrevButton;
	private boolean hasNextButton;
	
	
	
		
	
	
}
