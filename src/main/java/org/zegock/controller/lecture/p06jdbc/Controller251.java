package org.zegock.controller.lecture.p06jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex251")
public class Controller251 {

	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("sub01")
	public void method1() throws Exception {
		String sql = "INSERT INTO myTable07 (col1, col2, col3, col4, col5, col6)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, 9999999);
			pstmt.setDouble(2, 298342.333);
			pstmt.setString(3, "hello world");
			pstmt.setString(4, "sql");
			pstmt.setDate(5, java.sql.Date.valueOf("2022-10-01"));
			pstmt.setTimestamp(6, java.sql.Timestamp.valueOf("2011-11-11 12:12:12"));
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println(cnt + "개 레코드 입력 성공");
		}
	}
	
	@RequestMapping("sub02")
	public void method02() {
	
	}
	@RequestMapping("sub03")
	public void method03() {
		
	}
	
}






