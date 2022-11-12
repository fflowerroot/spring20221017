package org.zerock.domain.member;

import lombok.Data;

@Data
public class MemberDto {

	private int id;
	private String password;
	private String email;
}
