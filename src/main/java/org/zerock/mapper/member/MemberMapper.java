package org.zerock.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.domain.member.MemberDto;

@Mapper
public interface MemberMapper {

	int insert(MemberDto member);

	List<MemberDto> select();

}
