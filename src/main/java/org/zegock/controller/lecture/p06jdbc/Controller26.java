package org.zegock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex26")
public class Controller26 {
	@Autowired
	private DataSource dataSource;

	@RequestMapping("sub01")
	public void m1() throws SQLException {
		String sql = "INSERT INTO Customers (CustomerName) Values (?) ";
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, "s");
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int newKey = rs.getInt(1);
				System.out.println(newKey + "번 고객 입력됨.");
			}
		}
	}
	@RequestMapping("sub02")
	public void m2() throws SQLException {
		String sql = "INSERT INTO Employees (firstName) Values (?) ";
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
				//PreparedStatement ps = con.prepareStatement(sql, 1);) { 이렇게 해도 같은 결과. 
			ps.setString(1, "s");
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int newKey = rs.getInt(1);//Parameters:columnIndex the first column is 1, the second is 2, ...
										//Returns:the column value; if the value is SQL NULL, the value returned is 0
				System.out.println(newKey + "번 직원 입력됨.");
			}
		}
	}
	@RequestMapping("sub03")
	public void m3() throws SQLException {
		String sql = "INSERT INTO Bank (balance) Values (?) ";
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);) {
			ps.setInt(1, 11);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int newKey = rs.getInt(1); // 키가 숫자가 아니면 안되나?
				System.out.println(newKey + "번 직원 입력됨.");
			}
		}
	}
	
}
