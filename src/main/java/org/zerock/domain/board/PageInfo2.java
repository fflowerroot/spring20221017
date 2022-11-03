package org.zerock.domain.board;

import lombok.Data;

@Data
public class PageInfo2 {
	private String ss;
	private int lastPageNumber;
	private int leftPageNumber;
	private int rightPageNumber;
	private int currentPageNumber;
	private int jumpPrevPageNumber;
	private int jumpNextPageNumber;
	private boolean hasPrevButton;
	private boolean hasNextButton;
	
	
		
	
	
}
