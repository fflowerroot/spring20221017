package org.zerock.domain.member;

import lombok.Data;

@Data
public class MemberDto {

	private int id;
	private String password;
	private String password2;
	
	private String email;
	private String inserted;
	
}
