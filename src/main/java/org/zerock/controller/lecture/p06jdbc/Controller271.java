package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex271")
public class Controller271 {
	@Autowired
	private DataSource dataSource;

	@RequestMapping("sub01")
	public void m1() throws SQLException {
		String sql1 = "update Bank set balance = balance -5000 where customerId=2";
		String sql2 = "update Bank set balance = balance +5000 where customerId=1";
		System.out.println("ex27 sub01..");

		try (Connection con = dataSource.getConnection()) {
			try {
				// con.setAutoCommit(false);
				Statement st = con.createStatement();
				st.execute(sql1);

				int b = 3 / 0;

				Statement st2 = con.createStatement();
				st.execute(sql2);
				con.commit();

			} catch (Exception e) {
				con.rollback();
			}
		}
	}
	@GetMapping("sub02")
	public void method2() {		
	}
	
//	@PostMapping("sub02")	
//	public void method3(HttpServletRequest req) throws SQLException {
//		// Employee 테이블 INSERT 쿼리 실행
//		// Salary 테이블 INSERT 쿼리 실행
//		
//		// 위 두 쿼리가 모두 실행되거나
//		// 모두 실패할 수 있는 코드 작성
//		String sql1 = "UPDATE Employees set Salary=? where lastName=?";
//		String sql2 = "UPDATE Salary set Salary=? where lastName=?";
//
//		try (Connection con = dataSource.getConnection();) {
//			try {
//				con.setAutoCommit(false);
//				PreparedStatement pstmt1 = con.prepareStatement(sql1);
//				pstmt1.setInt(1,Integer.parseInt(req.getParameter("salary")));   // 요청폼으로받은
//		//		System.out.println(req.getParameter("salary"));
//				pstmt1.setString(2, req.getParameter("lname"));// 요청폼으로받은
//				pstmt1.executeUpdate();
//				System.out.println("1..");
//				PreparedStatement pstmt2 = con.prepareStatement(sql2);
//				pstmt2.setInt(1,Integer.parseInt(req.getParameter("salary")));   // 요청폼으로받은
//				pstmt2.setString(2, req.getParameter("lname"));// 요청폼으로받은
//				pstmt2.executeUpdate();
//				System.out.println("2..");
//				
//				con.commit();
//			} catch (Exception e) {
//				con.rollback();
//			}
//		}
//	}
	
	// java.lang.IllegalStateException: 
	//Optional int parameter 'salary' is present but cannot be translated into a null value due to being declared as a primitive type.
	//Consider declaring it as object wrapper for the corresponding primitive type.
	
	
	@PostMapping("sub02")	// 이건 포워드고, 리턴값은 리디렉트인가?
	public void method3(String fname, String lname, int salary) throws SQLException {
		// Employee 테이블 INSERT 쿼리 실행
		// Salary 테이블 INSERT 쿼리 실행
		
		// 위 두 쿼리가 모두 실행되거나
		// 모두 실패할 수 있는 코드 작성
		String sql1 = "UPDATE Employees1 set Salary=? where lastName=?";
		String sql2 = "UPDATE Salary1 set Salary=? where lastName=?";

		try (Connection con = dataSource.getConnection();) {
			try {
				con.setAutoCommit(false);
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				pstmt1.setInt(1,salary);   // 요청폼으로받은
		//		System.out.println(req.getParameter("salary"));
				pstmt1.setString(2, lname);// 요청폼으로받은
				pstmt1.executeUpdate();
				System.out.println("1..");
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1,salary);   // 요청폼으로받은
				pstmt2.setString(2, lname);// 요청폼으로받은
				pstmt2.executeUpdate();
				System.out.println("2..");
				
				con.commit();
			} catch (Exception e) {
				con.rollback();
			}
		}
	}
}
