package org.zegock.mapper.lecture;

import org.apache.ibatis.annotations.Select;

public interface Mapper01 {
	@Select("SELECT NOW()")
	public String getCurrentTime();
	
}
