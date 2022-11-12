package org.zerock.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.member.MemberDto;
import org.zerock.mapper.member.MemberMapper;

@Service
public class MemberService {

	@Autowired
	MemberMapper mapper;
	
	public int insert(MemberDto member) {
		return mapper.insert(member);
		
	}

	public List<MemberDto> select() {
		return mapper.select();
	}



}
